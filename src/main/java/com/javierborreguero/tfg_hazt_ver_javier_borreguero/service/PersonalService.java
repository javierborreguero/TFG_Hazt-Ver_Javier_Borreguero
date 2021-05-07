package com.javierborreguero.tfg_hazt_ver_javier_borreguero.service;

import com.javierborreguero.tfg_hazt_ver_javier_borreguero.entity.Personal;
import com.javierborreguero.tfg_hazt_ver_javier_borreguero.repository.PersonalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonalService {
    @Autowired
    private PersonalRepository personal_info_repo;

    public List<Personal> listAll() {
        return personal_info_repo.findAll();
    }

    public void save(Personal personal) {
        personal_info_repo.save(personal);
    }

    public Personal get(Long id) {
        return personal_info_repo.findById(id).get();
    }

    public void delete(Long id) {
        personal_info_repo.deleteById(id);
    }
}
