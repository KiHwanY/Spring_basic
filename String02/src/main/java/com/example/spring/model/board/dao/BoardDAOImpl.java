package com.example.spring.model.board.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import javax.sound.midi.Sequence;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.example.spring.model.board.dto.BoardDTO;

@Repository
public class BoardDAOImpl implements BoardDAO {

	@Inject
	SqlSession sqlsession;
	
	//첨부파일 레코드 삭제
	@Override
	public void deleteFile(String fullName) {
		sqlsession.delete("board.deleteFile", fullName);

	}

	@Override
	public List<String> getAttach(int bno) {
		
		return sqlsession.selectList("board.getAttach", bno);
	}

	@Override
	public void addAttach(String fullName) {
		sqlsession.insert("board.addAttach", fullName);

	}

	@Override
	public void updateAttach(String fullName, int bno) {
		Map<String, Object> map = new HashMap<>();
		map.put("fullName", fullName); //첨부파일 이름
		map.put("bno", bno); // 게시물 번호
		sqlsession.insert("board.updateAttach", map);
		//게시물 board 는 update 이지만 첨부파일 attach 는 기존 파일이 있더라도 기존것은 그대로 두거나
		// 또는 새 파일을 올려 수정하는 것이기 때문에 insert()를 쓴다.

	}

	@Override
	public void create(BoardDTO dto) throws Exception {
		sqlsession.insert("board.insert", dto);

	}

	@Override
	public void update(BoardDTO dto) throws Exception {
		sqlsession.update("board.update", dto);

	}

	@Override
	public void delete(int bno) throws Exception {
		sqlsession.delete("board.delete", bno);

	}

	@Override
	public List<BoardDTO> listAll(String search_option, String keyword,int start, int end) throws Exception {
		Map<String, Object> map = new HashMap<>();
		map.put("search_option", search_option);
		map.put("keyword", "%"+keyword+ "%");
		map.put("start", start);
		map.put("end", end);
		return sqlsession.selectList("board.listAll" , map) ;
	}

	@Override
	public void increaseViewcnt(int bno) throws Exception {
		sqlsession.update("board.increaseViewcnt", bno);

	}

	@Override
	public int countArticle() throws Exception {
		
		return sqlsession.selectOne("board.countArticle");
	}

	@Override
	public BoardDTO read(int bno) throws Exception {
	
		return sqlsession.selectOne("board.read", bno);
	}

}
