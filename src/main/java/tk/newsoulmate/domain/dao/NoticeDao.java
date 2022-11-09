package tk.newsoulmate.domain.dao;

import com.google.gson.Gson;
import tk.newsoulmate.domain.vo.Notice;
import tk.newsoulmate.domain.vo.Request;
import tk.newsoulmate.domain.vo.response.Body;
import tk.newsoulmate.domain.vo.response.Response;
import tk.newsoulmate.domain.vo.response.ResponseMapper;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.*;

public class NoticeDao {

    private static Properties prop=new Properties();
    public NoticeDao(){
        Properties prop=new Properties();
        String FilePath=NoticeDao.class.getResource("/sql/notice/Notice-Mapper.xml").getPath();
        try {
            prop.loadFromXML(new FileInputStream(FilePath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * 20개단위로 이미지를 반환하는 코드
     * @param request
     * @return
     */

    public Map<Long, String> getNoticeSubNail(Request request) {
        Map<Long, String> map = new HashMap<>(20);
        URL url = request.toUrl();
        ResponseMapper responseMapper=null;
        try {
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Content-type", "application/json");
            if(conn.getResponseCode()>=200&&conn.getResponseCode()<=300){
                Gson gson=new Gson();
                responseMapper = gson.fromJson(new InputStreamReader(conn.getInputStream(),"UTF-8"), ResponseMapper.class);
                int length=responseMapper.getResponse().getTotalCount();
                List<Notice> Nlist=responseMapper.getResponse().getBody().getItems().getItem();
                for (Notice n:Nlist) {
                    map.put(n.getDesertionNo(),n.getFilename());
                }


            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return map;
    }

//    public Notice getNoticeDetail(long){
//
//    }


    public int scrapNotice(Connection conn,int numberOfRows){
        Request request=new Request();
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE,  -14);
        request.setBgndate(cal.getTime());
        request.setPageNo(1);
        request.setNumberOfRows(numberOfRows);
        URL url = request.toUrl();
        System.out.println(url.toString());
        ResponseMapper responseMapper=null;
        List<Notice> Nlist=new ArrayList<>();
        int length=0;
        try {

            HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
            httpConn.setRequestMethod("GET");
            httpConn.setRequestProperty("Content-type", "application/json");
            if(httpConn.getResponseCode()>=200&&httpConn.getResponseCode()<=300){
                Gson gson=new Gson();
                responseMapper = gson.fromJson(new InputStreamReader(httpConn.getInputStream(),"UTF-8"), ResponseMapper.class);
                Response r =responseMapper.getResponse();
                Body b=r.getBody();
                length=r.getTotalCount();
                System.out.println(length);
                Nlist=b.getItems().getItem();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("결과수 : "+length);
        PreparedStatement trunkPsmt=null;
        PreparedStatement insertPsmt=null;
        String trunk=prop.getProperty("trunkNotice");
        String insert=prop.getProperty("InsertNotice");
        int result=0;
        try {
            trunkPsmt=conn.prepareStatement(trunk);
            result=trunkPsmt.executeUpdate();
            if(result>0){
                insertPsmt=conn.prepareStatement(insert);
                for(Notice n:Nlist){
                    insertPsmt.setLong(1,n.getDesertionNo());
                    insertPsmt.setString(2,n.getFilename());
                    insertPsmt.setDate(3,n.getHappenDt());
                    insertPsmt.setString(4,n.getHappenPlace());
                    insertPsmt.setString(5,n.getKindCd());
                    insertPsmt.setString(6,n.getColorCd());
                    insertPsmt.setString(7,n.getAge());
                    insertPsmt.setString(8,n.getWeight());
                    insertPsmt.setString(9,n.getNoticeNo());
                    insertPsmt.setDate(10,n.getNoticeSdt());
                    insertPsmt.setDate(11,n.getNoticeEdt());
                    insertPsmt.setString(12,n.getPopfile());
                    insertPsmt.setString(13,n.getProcessState());
                    insertPsmt.setString(14,n.getSexCd());
                    insertPsmt.setString(15,n.getNeuterYn());
                    insertPsmt.setString(16,n.getSpecialMark());
                    insertPsmt.setString(17,n.getCareNm());
                    insertPsmt.setString(18,n.getCareTel());
                    insertPsmt.setString(19,n.getCareAddr());
                    insertPsmt.setString(20,n.getOrgNm());
                    insertPsmt.setString(21,n.getChargeNm());
                    insertPsmt.setString(22,n.getOfficetel());
                    insertPsmt.setString(23,n.getNoticeComment());
                    result+=insertPsmt.executeUpdate();
                    System.out.println(result);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;


    }


}
