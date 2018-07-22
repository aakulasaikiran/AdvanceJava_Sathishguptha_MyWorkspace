package com.nt.dao;

import java.util.List;

import com.nt.bo.BookBO;

public interface SearchBookDAO {
  public List<BookBO> findBooks(String category)throws Exception;
}
