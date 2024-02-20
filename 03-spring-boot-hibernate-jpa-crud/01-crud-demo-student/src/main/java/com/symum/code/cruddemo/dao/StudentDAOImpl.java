    package com.symum.code.cruddemo.dao;

    import com.symum.code.cruddemo.entity.Student;
    import jakarta.persistence.EntityManager;
    import jakarta.persistence.TypedQuery;
    import jakarta.transaction.Transactional;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Repository;

    import java.util.List;

    @Repository
    public class StudentDAOImpl implements StudentDAO{
        //define field for the entity manager
        private EntityManager entityManager;
        // inject entity manager using constructor injection
        @Autowired
        public StudentDAOImpl(EntityManager entityManager) {
            this.entityManager = entityManager;
        }

        // implement save method
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
            // Create a query
            TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student",Student.class);
            // from the above the query will do this as ascending and
            // if you want to change it to desecending type desc. <orderr by>
            // Return query result
            return theQuery.getResultList();
        }

        @Override
        public List<Student> findByLastName(String theLastName) {
            // Create query
            TypedQuery<Student> theQuery = entityManager.createQuery(
                    "FROM Student WHERE lastName =:theData", Student.class);
            // Set query parameter
            theQuery.setParameter("theData", theLastName);
            // Return query results
            return theQuery.getResultList();
        }

        @Override
        @Transactional
        public void update(Student theStudent) {
            entityManager.merge(theStudent);
        }

        @Override
        @Transactional
        public void delete(Integer id) {
            // Retrieve the student delete the student
            Student theStudent = entityManager.find(Student.class, id);
            // Delete the student
            entityManager.remove(theStudent);
        }

        // for deleting all
        @Override
        @Transactional
        public int deleteAll() {
            int numRowsDeleted = entityManager.createQuery("DELETE FROM Student").executeUpdate();
            return numRowsDeleted;
        }


    }
