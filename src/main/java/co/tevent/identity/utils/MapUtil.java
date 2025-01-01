package co.tevent.identity.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Component
public class MapUtil {

    private static ModelMapper modelMapper = new ModelMapper();
    private static ObjectMapper objectMapper = new ObjectMapper();

    public static <T> String objectToJson(T Object) throws JsonProcessingException {
        return objectMapper.writeValueAsString(Object);
    }

    public static <T> T jsonToObject(String json, Class<T> Object) throws JsonProcessingException {
        return objectMapper.readValue(json, Object);
    }

    /**
     * Dto to Entity
     *
     * @param dto         , Dto there will be convert
     * @param entityClass , Entity Class target
     * @return Entity
     */
    public static <D, E> E toEntity(D dto, Class<E> entityClass) {
        return modelMapper.map(dto, entityClass);
    }

    // Method toDto: Entity to DTO

    /**
     * Entity to DTO
     *
     * @param entity   , Entity there will be convert
     * @param dtoClass , Dto class target
     * @return DTO
     */
    public static <E, D> D toDto(E entity, Class<D> dtoClass) {
        return modelMapper.map(entity, dtoClass);
    }

    /**
     * Method toEntityList: List of DTOs to List of Entities
     *
     * @param dtoList     , List DTO Source
     * @param entityClass , Entity Class Destination
     * @return List Entity!
     */
    public static <D, E> List<E> toEntityList(List<D> dtoList, Class<E> entityClass) {
        return dtoList.stream()
                .map(dto -> toEntity(dto, entityClass))
                .collect(Collectors.toList());
    }

    /**
     * Method toDtoList: List of Entities to List of DTOs
     *
     * @param entityList , List Entity Source
     * @param dtoClass   , DTO Class Destination
     * @return List DTO
     */
    public static <E, D> List<D> toDtoList(List<E> entityList, Class<D> dtoClass) {
        return entityList.stream()
                .map(entity -> toDto(entity, dtoClass))
                .collect(Collectors.toList());
    }

    /**
     * Method toDtoPage: Pagination DTO
     *
     * @param entityPage , entity page
     * @param dtoClass   , DTO Class
     * @return List Class
     */
    public static <E, D> Page<D> toDtoPage(Page<E> entityPage, Class<D> dtoClass) {
        List<D> dtoList = entityPage.getContent().stream()
                .map(entity -> toDto(entity, dtoClass))
                .collect(Collectors.toList());
        return new PageImpl<>(dtoList, PageRequest.of(entityPage.getNumber(), entityPage.getSize()), entityPage.getTotalElements());
    }

    /**
     * Method toDtoPage: Map target class
     *
     * @param source      , source class
     * @param targetClass , target class
     * @return Object List
     */
    public static <S, T> T map(S source, Class<T> targetClass) {
        try {
            T target = targetClass.getDeclaredConstructor().newInstance();
            BeanUtils.copyProperties(source, target);
            return target;
        } catch (Exception e) {
            throw new RuntimeException("Error mapping objects", e);
        }
    }

    /**
     * Build additional claims data!
     * @param data, contain data Object
     * @return Maps<String, Object>
     */
    public static <T> Map<String, Object> listToMap(T data) {
        Map<String, Object> claims = new HashMap<>();
        Field[] fields = data.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            try {
                Object value = field.get(data);
                claims.put(field.getName(), value);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return claims;
    }
}