package com.residencia.academia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.residencia.academia.DTO.AtividadeDTO;
import com.residencia.academia.DTO.TurmaDTO;
import com.residencia.academia.entity.Atividade;
import com.residencia.academia.entity.Turma;
import com.residencia.academia.repository.AtividadeRepository;

@Service
public class AtividadeService {
	@Autowired
	AtividadeRepository atividadeRepository;
	
	public List<Atividade> findAllAtividade(){
		return atividadeRepository.findAll();
	}
	
	public AtividadeDTO findAtividadeDTOById(Integer id) {
		Atividade atividade = atividadeRepository.findById(id).isPresent() ? atividadeRepository.findById(id).get()
				: null;
		AtividadeDTO atividadeDTO = new AtividadeDTO();
		if (null != atividade) {
			atividadeDTO = converterEntidadeParaDTO(atividade);
		}
		return atividadeDTO;
	}
	
	private AtividadeDTO converterEntidadeParaDTO(Atividade atividade) {
		AtividadeDTO atividadeDTO = new AtividadeDTO();
		atividadeDTO.setAtividadeId(atividade.getAtividadeId());
		atividadeDTO.setNomeAtividade(atividade.getNomeAtividade());
		
		
		return atividadeDTO;
	}
	
	public Atividade findAtividadeById(Integer id) {
		return atividadeRepository.findById(id).isPresent() ? atividadeRepository.findById(id).get():null;
	}
	
	public Atividade saveAtividade(Atividade atividade) {
		return atividadeRepository.save(atividade);
	}
	
	public Atividade updateAtividade(Atividade atividade) {
		return atividadeRepository.save(atividade);
	}
	
	public void deleteAtividade(Integer id) {
		Atividade atividade = atividadeRepository.findById(id).get();
		atividadeRepository.delete(atividade);
	}

}
