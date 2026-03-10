package springboot_ecommerce.springboot_ecommerce.service.impl;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.annotation.JsonAppend.Attr;

import springboot_ecommerce.springboot_ecommerce.dto.request.CreateAttributeRequest;
import springboot_ecommerce.springboot_ecommerce.dto.response.AttributeResponse;
import springboot_ecommerce.springboot_ecommerce.entity.Attribute;
import springboot_ecommerce.springboot_ecommerce.entity.AttributeGroup;
import springboot_ecommerce.springboot_ecommerce.entity.Category;
import springboot_ecommerce.springboot_ecommerce.repository.AttributeGroupRepository;
import springboot_ecommerce.springboot_ecommerce.repository.AttributeRepository;
import springboot_ecommerce.springboot_ecommerce.repository.CategoryRepository;
import springboot_ecommerce.springboot_ecommerce.service.AttributeService;

@Service
public class AttributeServiceImpl implements AttributeService {

    private final AttributeRepository attributeRepository;
    private final CategoryRepository categoryRepository;
    private final AttributeGroupRepository attributeGroupRepository;

    public AttributeServiceImpl(AttributeRepository attributeRepository, CategoryRepository categoryRepository,
            AttributeGroupRepository attributeGroupRepository) {
        this.attributeRepository = attributeRepository;
        this.categoryRepository = categoryRepository;
        this.attributeGroupRepository = attributeGroupRepository;
    }

    @Override

    public List<AttributeResponse> getByGroupId(Long idGroup) {
        if (!attributeGroupRepository.existsById(idGroup)) {
            throw new RuntimeException("Group is not found with id" + idGroup);
        }
        return attributeRepository.findByAttributeGroup_IdGroup(idGroup);
    }

    // @Override
    // public void createAttribute(Long idGroupAttribute, CreateAttributeRequest
    // createAttributeRequest) {
    // if(!attributeGroupRepository.existsById(idGroupAttribute)){
    // throw new RuntimeException("Group is not found with id" + idGroupAttribute);
    // }
    // return
    // }
}
