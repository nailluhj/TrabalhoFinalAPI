package org.serratec.projetofinal.ApiRestful.service;

import java.io.IOException;
import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.serratec.projetofinal.ApiRestful.DTO.RelacionamentoDTO;
import org.serratec.projetofinal.ApiRestful.model.Relacionamento;
import org.serratec.projetofinal.ApiRestful.repository.RelacionamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@Service
public class RelacionamentoService {

    @Autowired
    private RelacionamentoRepository relacionamentoRepository;

    @Autowired
    private FotoService fotoService;

    public List<RelacionamentoDTO> listar() {
        List<Relacionamento> relacionamentoList = relacionamentoRepository.findAll();

        return relacionamentoList.stream()
                .map(this::adicionaImagemURI)
                .collect(Collectors.toList());
    }

    public RelacionamentoDTO adicionaImagemURI(Relacionamento relacionamento) {
        URI uri = ServletUriComponentsBuilder
                .fromCurrentContextPath()
                .path("/relacionamento/{id}/foto")
                .buildAndExpand(relacionamento.getId())
                .toUri();

        RelacionamentoDTO dto = new RelacionamentoDTO();
        dto.setUsuarioDTO(relacionamento.getUsuarioDTO());
        dto.setDataInicio(relacionamento.getDataInicio());
        dto.setUrl(uri.toString());
        return dto;
    }

    public RelacionamentoDTO buscar(Long id) {
        Optional<Relacionamento> relacionamentoOpt = relacionamentoRepository.findById(id);
        if (relacionamentoOpt.isEmpty()) {
            return null;
        }
        return adicionaImagemURI(relacionamentoOpt.get());
    }

    public RelacionamentoDTO inserir(MultipartFile file, Relacionamento relacionamento) throws IOException {
        relacionamento = relacionamentoRepository.save(relacionamento);
        fotoService.inserir(relacionamento, file);
        relacionamento = relacionamentoRepository.save(relacionamento);
        return adicionaImagemURI(relacionamento);
    }
}
