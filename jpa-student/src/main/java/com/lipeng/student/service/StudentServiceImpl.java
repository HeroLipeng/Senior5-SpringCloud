package com.lipeng.student.service;

import com.lipeng.student.dao.ClazzRepository;
import com.lipeng.student.dao.StudentRepository;
import com.lipeng.student.entity.Clazz;
import com.lipeng.student.entity.Domain;
import com.lipeng.student.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private ClazzRepository clazzRepository;

    @Override
    public Page list(Integer pageNum, Integer pageSize, Domain domain) {
        Specification specification=new Specification() {
            @Override
            public Predicate toPredicate(Root root, CriteriaQuery criteriaQuery, CriteriaBuilder criteriaBuilder) {
               //创建一个集合
                List<Predicate> predicates=new ArrayList<>();
                //保存查询集合
                if (!StringUtils.isEmpty(domain.getName())){
                    Predicate predicate=criteriaBuilder.like(root.get("name"),"%".concat(domain.getName().concat("%")));
                    predicates.add(predicate);
                }
                //查询班级集合
                if (domain.getClassId()>0){
                    Predicate predicate=criteriaBuilder.equal(root.get("classId"),domain.getClassId());
                    predicates.add(predicate);
                }


                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        };


        Pageable pageable=PageRequest.of(pageNum-1,pageSize);
        return studentRepository.findAll(specification,pageable);
    }

    @Override
    public boolean saveOrUpdate(Student student) {
        studentRepository.save(student);
        return true;
    }

    @Override
    public List<Clazz> getAll() {
        return clazzRepository.findAll();
    }

    @Override
    public boolean delete(Integer[] ids) {
        for (Integer id:ids) {
            studentRepository.deleteById(id);
        }
        return true;
    }

    @Override
    public boolean addCla(Clazz clazz) {
         clazzRepository.save(clazz);
         return true;
    }
}
