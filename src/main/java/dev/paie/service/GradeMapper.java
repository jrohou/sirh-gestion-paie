package dev.paie.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import dev.paie.entite.Grade;

public class GradeMapper implements RowMapper<Grade> {

	@Override
	public Grade mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Grade nouveauGrade = new Grade();
		nouveauGrade.setId(rs.getInt("id"));
		nouveauGrade.setCode(rs.getString("code"));
		nouveauGrade.setNbHeuresBase(rs.getBigDecimal("nbHeuresBase"));
		nouveauGrade.setTauxBase(rs.getBigDecimal("tauxBase"));
		
		return nouveauGrade;
	}

}
