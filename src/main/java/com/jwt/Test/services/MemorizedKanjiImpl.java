package com.jwt.Test.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jwt.Test.entiites.MemorizedKanji;
import com.jwt.Test.repositories.MemorizedKanjiRepository;




@Service
public class MemorizedKanjiImpl implements MemorizedKanjiService {
	
	@Autowired
	MemorizedKanjiRepository repo;

	@Override
	public MemorizedKanji save(MemorizedKanji word) {
		// TODO Auto-generated method stub
		word.setDate(LocalDate.now().toString());	
		word.setCount(1);
		return repo.save(word);
	}

	@Override
	public List<MemorizedKanji> getAll(int id) {
		// TODO Auto-generated method stub
		return (List<MemorizedKanji>) repo.findByUser_id(id);
	}

	@Override
	public void delete(int id) {
		repo.deleteById(id);
		
	}

	@Override
	public MemorizedKanji getById(int id) {
		// TODO Auto-generated method stub
		return repo.findById(id).orElse(null);
	}

	@Override
	public MemorizedKanji editMemo(int id, MemorizedKanji kanji) {		
		MemorizedKanji toUpdate=this.getById(id);
		if(toUpdate==null)  return null;
		toUpdate.setMemo(kanji.getMemo());
		toUpdate.setCount(toUpdate.getCount()+1);
		MemorizedKanji updated=repo.save(toUpdate);		
		return updated;
	}

}
