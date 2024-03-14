package com.example.Fixture.Mappers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.example.Fixture.Dto.UsuarioDTO;
import com.example.Fixture.Model.Usuario;

@Component
public class UsuarioMapper {

    public UsuarioDTO originalToDTO(Usuario usuario) {
        UsuarioDTO dtoUser = new UsuarioDTO();
        dtoUser.setId(usuario.getId());
        dtoUser.setNombre(usuario.getNombre());
        dtoUser.setApellido(usuario.getApellido());
        dtoUser.setMail(usuario.getMail());
        dtoUser.setContrasenia(usuario.getContrasenia());
        dtoUser.setRoles(usuario.getAutoridades());
        return dtoUser;
    }

    public Usuario dto2Model(UsuarioDTO userDTO) {
        Usuario newUser = new Usuario();
        //newUser.setId(userDTO.getId());
        newUser.setNombre(userDTO.getNombre());
        newUser.setApellido(userDTO.getApellido());
        newUser.setMail(userDTO.getMail());
        newUser.setContrasenia(userDTO.getContrasenia());
        //PARSEO DE COLLECTION A LISTA
        newUser.setAutoridades(userDTO.getRoles().stream().collect(Collectors.toList()));
        return newUser;
    }

    public List<UsuarioDTO> modelUserToUserDTO(List<Usuario> usuariosList) {
        List<UsuarioDTO> dtoList = usuariosList
                .stream()
                .map(i -> this.originalToDTO(i))
                .collect(Collectors.toList());
        return dtoList;
    }

    public void userEntityRefreshValues(Usuario userEntity, UsuarioDTO dto) {
        if (dto.getMail() != null && dto.getMail().isBlank()) {
            userEntity.setMail(dto.getMail());
        }
        if (dto.getNombre() != null && !dto.getNombre().isBlank()) {
            userEntity.setNombre(dto.getNombre());
        }
        if (dto.getApellido() != null && !dto.getApellido().isBlank()) {
            userEntity.setApellido(dto.getApellido());
        }
        if (dto.getMail() != null && !dto.getMail().isBlank()) {
            userEntity.setMail(dto.getMail());
        }
        if (dto.getContrasenia() != null && !dto.getContrasenia().isBlank()) {
            userEntity.setContrasenia(dto.getContrasenia());
        }
        userEntity.setAutoridades(dto.getRoles().stream().collect(Collectors.toList()));
    }
}