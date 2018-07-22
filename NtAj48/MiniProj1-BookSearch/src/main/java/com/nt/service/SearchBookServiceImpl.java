package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import com.nt.bo.BookBO;
import com.nt.dao.SearchBookDAO;
import com.nt.dao.SearchBookDAOImpl;
import com.nt.dto.BookDTO;

public class SearchBookServiceImpl implements SearchBookService {

	@Override
	public List<BookDTO> searchBooks(String category) throws Exception {
		 SearchBookDAO dao=null;
		 List<BookBO> listBO=null;
		 List<BookDTO> listDTO=new ArrayList();;
		 //use dAO
		 dao=new SearchBookDAOImpl();
		 listBO=dao.findBooks(category);
		 //copy listBO to listDTO
		 listBO.forEach(bo->{
			 BookDTO dto=new BookDTO();
			 dto.setBookId(bo.getBookId());
			 dto.setBookName(bo.getBookName());
			 dto.setAuthorName(bo.getAuthorName());
			 dto.setStatus(bo.getStatus());
			 dto.setCategory(bo.getCategory());
			 listDTO.add(dto);
		 });
		return listDTO;
	}

}
