package com.member_manager.repository;

import com.member_manager.domain.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@Repository
public class MemberRepository {

    private final DataSource dataSource;
    final int SIGNUP_ERROR = -1;

    @Autowired
    public  MemberRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public int addMember(Member member){
        String sql = "insert into members (email, password, nickname, name, phone) values(?,?,?,?,?)";
        try(Connection conn = dataSource.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setString(1, member.getEmail());
            pstmt.setString(2, member.getPassword());
            pstmt.setString(3, member.getNickname());
            pstmt.setString(4, member.getName());
            pstmt.setString(5, member.getPhone());
            return pstmt.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
            return SIGNUP_ERROR;
        }
    }

    public Member checkMember(Member member){
        String sql = "select * from members where email=? and password=?";
        try(Connection conn = dataSource.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setString(1, member.getEmail());
            pstmt.setString(2, member.getPassword());
            try(ResultSet rs = pstmt.executeQuery()){
                if(rs.next()){
                    return new Member(rs.getInt("access_lv"),
                            rs.getString("phone"),
                            rs.getString("nickname"),
                            rs.getString("name"),
                            rs.getString("password"),
                            rs.getString("email"),
                            rs.getInt("id"));
                }else{
                    return null;
                }
            }catch (Exception e2){
                e2.printStackTrace();
                return null;
            }

        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
