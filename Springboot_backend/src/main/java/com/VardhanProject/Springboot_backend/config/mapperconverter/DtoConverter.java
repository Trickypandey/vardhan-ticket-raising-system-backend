package com.VardhanProject.Springboot_backend.config.mapperconverter;

import org.springframework.stereotype.Service;

@Service
public interface DtoConverter<D, M> {
    M convert(D dto, Class<M> modelClass);
}