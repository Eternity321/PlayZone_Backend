package com.playzone.user.web.mapper;

public interface Mappable<E, D> {

    E toEntity(D d);

    D toDto(E entity);

}
