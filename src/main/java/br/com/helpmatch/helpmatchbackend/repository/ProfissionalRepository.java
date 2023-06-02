package br.com.helpmatch.helpmatchbackend.repository;

import br.com.helpmatch.helpmatchbackend.entity.ProfissionalEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class ProfissionalRepository implements CrudRepository<ProfissionalEntity, Long> {

    public Map<Long,ProfissionalEntity> db = new HashMap<>();
    public int index = 0;

    @Override
    public ProfissionalEntity save(ProfissionalEntity entity) {

        if(entity.getId() == null){
            entity.setId(index+1l);
            index++;
        }

        db.put(entity.getId(),entity);
        return entity;
    }
    @Override
    public Optional<ProfissionalEntity> findById(Long id) {
        return Optional.ofNullable( db.get( id ) );
    }

    @Override
    public boolean existsById(Long id) {
        return db.get( id ) != null;
    }

    @Override
    public Iterable<ProfissionalEntity> findAll() {
        return db.values();
    }

    @Override
    public Iterable<ProfissionalEntity> findAllById(Iterable<Long> longs) {
        ArrayList<ProfissionalEntity> listProfissionais = new ArrayList<>();
        for(Long id : longs){
            ProfissionalEntity profissional = db.get(id);
            if(profissional != null){
                listProfissionais.add(profissional);
            }
        }
        return listProfissionais;
    }

    @Override
    public long count() {
        return db.size();
    }

    @Override
    public void deleteById(Long id) {
        db.remove(id);
    }

    @Override
    public void delete(ProfissionalEntity entity) {
        db.remove(entity.getId());
    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends ProfissionalEntity> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends ProfissionalEntity> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }
}
