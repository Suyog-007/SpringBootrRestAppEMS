package org.shah.springapp.ems.Services;

import org.shah.springapp.ems.Domains.Member;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import java.util.List;

@Service
public class MemberService {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Member> getMembersByAttributes(String location, Integer experience, String status, String positionLevel, String employeeId, String orderByDateOfJoining) {
        StringBuilder queryString = new StringBuilder("SELECT m FROM Member m WHERE 1=1");

        if (location != null) {
            queryString.append(" AND m.location = :location");
        }
        if (experience != null) {
            queryString.append(" AND m.experience = :experience");
        }
        if (status != null) {
            queryString.append(" AND m.status = :status");
        }
        if (positionLevel != null) {
            queryString.append(" AND m.positionLevel = :positionLevel");
        }
        if (employeeId != null) {
            queryString.append(" AND m.employeeId = :employeeId");
        }

        if ("asc".equalsIgnoreCase(orderByDateOfJoining)) {
            queryString.append(" ORDER BY m.dateOfJoining ASC");
        } else if ("desc".equalsIgnoreCase(orderByDateOfJoining)) {
            queryString.append(" ORDER BY m.dateOfJoining DESC");
        }

        Query query = entityManager.createQuery(queryString.toString());

        if (location != null) {
            query.setParameter("location", location);
        }
        if (experience != null) {
            query.setParameter("experience", experience);
        }
        if (status != null) {
            query.setParameter("status", status);
        }
        if (positionLevel != null) {
            query.setParameter("positionLevel", positionLevel);
        }
        if (employeeId != null) {
            query.setParameter("employeeId", employeeId);
        }

        return query.getResultList();
    }
}
