package br.com.helpmatch.helpmatchbackend.service;

import br.com.helpmatch.helpmatchbackend.dto.ProfissionalDto;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

public interface ProfissionalService {
    /**
     * Metodo para pegar um profissional pelo Id dele
     * @param id - Identificador do profissional
     * @return ProfissionalDTO - profissional correspondente ao Id
     */
    public Optional<ProfissionalDto> getById(Long id);

    /**
     * Metodo para pegar todos os profissional
     * @return List<ProfissionalDto> - Lista com todos os profissionais na sistema
     */
    public List<ProfissionalDto> getAll();

    /**
     * Metodo para criar um Profissional
     * @param profissional - Profissional que sera criado
     * @return ProfissionalDto - Profissional criado
     */
    public Optional<ProfissionalDto> create(ProfissionalDto profissional);

    /**
     * Metodo para criar um profissional
     * @param id - Identificador do cliente que sera atualizado
     * @param profissional - Profissional com os novos dados
     * @return ProfissionalDto - Profissional com os dados atualizados
     */
    public Optional<ProfissionalDto> update(Long id, ProfissionalDto profissional);

    /**
     * Metodo para remover um profissional
     * @param id - Identificador do profissional que sera removido
     */
    @Transactional
    public void delete(Long id);
}
