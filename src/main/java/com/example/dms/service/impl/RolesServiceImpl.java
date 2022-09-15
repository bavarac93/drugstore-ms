package com.example.dms.service.impl;

import com.example.dms.dao.RolesRepository;
import com.example.dms.dto.RolesRequest;
import com.example.dms.dto.RolesResponse;
import com.example.dms.exception.ApiRequestException;
import com.example.dms.mapper.RolesMapper;
import com.example.dms.model.RolesEntity;
import com.example.dms.service.RolesService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.MessageFormat;
import java.util.List;
import java.util.Objects;

@Service
@Transactional
public class RolesServiceImpl implements RolesService {

    private static final String ROLE_DOES_NOT_EXIST = "Role with this id: {0} does not exist.";
    private final RolesRepository rolesRepository;
    private final RolesMapper rolesMapper;


    public RolesServiceImpl(final RolesRepository rolesRepository, final RolesMapper rolesMapper) {
        this.rolesRepository = Objects.requireNonNull(rolesRepository, "rolesRepository cannot be null");
        this.rolesMapper = Objects.requireNonNull(rolesMapper, "rolesMapper cannot be null");
    }

    private boolean roleExists(final String name) {
        return rolesRepository.findByName(name) != null;
    }

    @Override
    public RolesResponse create(final RolesRequest rolesRequest) {
        final RolesEntity rolesEntity = rolesMapper.dtoToEntity(rolesRequest);
        final RolesEntity saveRolesEntity = rolesRepository.save(rolesEntity);
        return rolesMapper.entityToDto(saveRolesEntity);
    }

    @Override
    public List<RolesResponse> findAll() {
        List<RolesEntity> rolesEntityList = rolesRepository.findAll();
        return rolesMapper.entitiesToDto(rolesEntityList);
    }

    @Override
    public List<RolesResponse> findAllRolesByName(final String name) {
        List<RolesEntity> entities = rolesRepository.findAllRolesByName(name);
        return rolesMapper.entitiesToDto(entities);
    }

    @Override
    public void deleteById(final Long id) {
        if (!rolesRepository.existsById(id)) {
            throw new ApiRequestException(
                    MessageFormat.format(ROLE_DOES_NOT_EXIST, id));
        }
        rolesRepository.deleteById(id);
    }
}
