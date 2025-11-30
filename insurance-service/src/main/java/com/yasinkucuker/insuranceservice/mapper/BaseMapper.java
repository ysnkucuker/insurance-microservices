package com.yasinkucuker.insuranceservice.mapper;

public interface BaseMapper<T, S> {
    T map(S model, Object... params);
}
