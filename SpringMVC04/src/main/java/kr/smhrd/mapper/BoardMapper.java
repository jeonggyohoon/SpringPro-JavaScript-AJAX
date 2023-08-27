package kr.smhrd.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Update;

import kr.smhrd.entity.Board;
import kr.smhrd.entity.Criteria;

// JDBC(Java+SQL) --> MyBatis Framework(Java<--->SQL(xml))
public interface BoardMapper {
	
	// 데이터베이스 접속(Connection) --> config.xml(jdbc url, username, password)
	//SqlSessionFactory sc = 
	// 1. 전체 게시판 리스트 가져오기
	public List<Board> boardList(Criteria cri); //추상메서드
	public void boardInsert(Board vo);
	public Board boardGet(int num);
	
	@Update("update reply set bdelete=1 where num=#{num}")
	public void boardDelete(int num);
	
	public void boardModify(Board vo);
	
	//조회수 누적 메서드
	@Update("update reply set count=count+1 where num=#{num}")
	public void count(int num);
	
	// 답글의 bseq+1
	public void replySeqUpdate(Board pvo);
	
	// 답글 저장 메서드
	public void replyInsert(Board vo);
	
	// 전체 게시글의 수를 구하는 메서드
	public int totalCount(Criteria cri);
}

/*
 * public SqlSessionFactoryBean implements BoardMapper{ public List<Board>
 * boardList(){ } } BoardMapper mapper = new SqlSessionFactoryBean();
 * mapper.boardList();
 */
