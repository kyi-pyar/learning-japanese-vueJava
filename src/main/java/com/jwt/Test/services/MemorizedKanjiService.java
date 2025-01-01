package com.jwt.Test.services;

import java.util.List;

import com.jwt.Test.entiites.MemorizedKanji;




public interface MemorizedKanjiService {
	public MemorizedKanji save(MemorizedKanji word);
	public List<MemorizedKanji> getAll(int id);
	public void delete(int id);
	public MemorizedKanji getById(int  id);
	public MemorizedKanji editMemo(int id,MemorizedKanji kanji);
	

}
