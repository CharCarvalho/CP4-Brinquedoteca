package com.brinquedoteca.fiap.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brinquedoteca.fiap.model.BrinquedotecaModel;
import com.brinquedoteca.fiap.repository.BrinquedotecaRepository;

@Service
public class BrinquedotecaService {
	
	@Autowired
	private BrinquedotecaRepository brinquedoRepository;
	
	public BrinquedotecaModel createBrinquedo(BrinquedotecaModel brinquedo) {
		return brinquedoRepository.save(brinquedo);
	}
	
	public List<BrinquedotecaModel> createBrinquedos(List<BrinquedotecaModel> brinquedos){
		return brinquedoRepository.saveAll(brinquedos);
	}
	
	public List<BrinquedotecaModel> getAllBrinquedos(){
		return brinquedoRepository.findAll();
	}
	public Optional<BrinquedotecaModel> getBrinquedoById(Long id){
		return brinquedoRepository.findById(id);
	}

	public Optional<BrinquedotecaModel> updateBrinquedo(Long id, BrinquedotecaModel brinquedoDetails){
		return brinquedoRepository.findById(id).map(brinquedo ->{
			brinquedo.setNm_brinquedo(brinquedoDetails.getNm_brinquedo());
			brinquedo.setTipo_brinquedo(brinquedoDetails.getTipo_brinquedo());
			brinquedo.setClassificacao_brinquedo(brinquedoDetails.getClassificacao_brinquedo());
			brinquedo.setTamanho_brinquedo(brinquedoDetails.getTamanho_brinquedo());
			brinquedo.setPreco_brinquedo(brinquedoDetails.getPreco_brinquedo());
			return brinquedoRepository.save(brinquedo);
		});
	}
	
	public Optional<BrinquedotecaModel> patchBrinquedo(Long id, BrinquedotecaModel brinquedoDetails) {
        return brinquedoRepository.findById(id).map(brinquedo -> {
            if (brinquedoDetails.getNm_brinquedo() != null) {
                brinquedo.setNm_brinquedo(brinquedoDetails.getNm_brinquedo());
            }
            if (brinquedoDetails.getTipo_brinquedo() != null) {
                brinquedo.setTipo_brinquedo(brinquedoDetails.getTipo_brinquedo());
            }
            if (brinquedoDetails.getClassificacao_brinquedo() != null) {
                brinquedo.setClassificacao_brinquedo(brinquedoDetails.getClassificacao_brinquedo());
            }
            if (brinquedoDetails.getTamanho_brinquedo() != null) {
                brinquedo.setTamanho_brinquedo(brinquedoDetails.getTamanho_brinquedo());
            }
            if (brinquedoDetails.getPreco_brinquedo() != null) {
                brinquedo.setPreco_brinquedo(brinquedoDetails.getPreco_brinquedo());
            }
            return brinquedoRepository.save(brinquedo);
        });
    }
	
	public boolean deleteBrinquedo(Long id) {
		return brinquedoRepository.findById(id).map(brinquedo ->{
			brinquedoRepository.delete(brinquedo);
			return true;
		}).orElse(false);
	}
	
}
