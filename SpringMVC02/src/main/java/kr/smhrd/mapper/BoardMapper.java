package kr.smhrd.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Update;

import kr.smhrd.entity.Board;

// JDBC(Java+SQL) --> MyBatis Framework(Java<--->SQL(xml))
public interface BoardMapper {
	
	// 데이터베이스 접속(Connection) --> config.xml(jdbc url, username, password)
	//SqlSessionFactory sc = 
	// 1. 전체 게시판 리스트 가져오기
	public List<Board> boardList(); //추상메서드
	public void boardInsert(Board vo);
	public Board boardGet(int num);
	
	@Delete("delete from memboard where num=#{num}")
	public void boardDelete(int num);
	public void boardModify(Board vo);
	
	//조회수 누적 메서드
	@Update("update memboard set count=count+1 where num=#{num}")
	public void count(int num);
}

/*
 * public SqlSessionFactoryBean implements BoardMapper{ public List<Board>
 * boardList(){ } } BoardMapper mapper = new SqlSessionFactoryBean();
 * mapper.boardList();
 */
