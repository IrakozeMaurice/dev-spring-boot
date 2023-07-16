package com.irakozemaurice.cruddemo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.irakozemaurice.cruddemo.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class StudentDAOImpl implements StudentDAO{
	
	private EntityManager entityManager;
	
	@Autowired
	public StudentDAOImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}

	@Override
	@Transactional
	public void save(Student theStudent) {
		entityManager.persist(theStudent);
	}

	@Override
	public Student findById(Integer id) {
		return entityManager.find(Student.class, id);
	}

	@Override
	public List<Student> findAll() {
		TypedQuery<Student> query = entityManager.createQuery("FROM Student",Student.class);
		List<Student> students = query.getResultList();
		return students;
	}

	@Override
	public List<Student> findByLastname(String theLastname) {
		TypedQuery<Student> query = entityManager.createQuery("FROM Student where lastname=:lastname",Student.class);
		query.setParameter("lastname", theLastname);
		return query.getResultList();
	}

	@Override
	@Transactional
	public void update(Student theStudent) {
		entityManager.merge(theStudent);
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		Student student = entityManager.find(Student.class, id);
		entityManager.remove(student);
	}

	@Override
	@Transactional
	public int deleteAll() {
		int numberOfRowsDeleted = entityManager.createQuery("delete FROM Student")
												.executeUpdate();
		
		return numberOfRowsDeleted;
	}
}
