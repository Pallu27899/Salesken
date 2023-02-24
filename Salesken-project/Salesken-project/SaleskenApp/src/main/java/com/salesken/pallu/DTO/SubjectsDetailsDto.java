package com.salesken.pallu.DTO;

import com.salesken.pallu.model.Semester;
import com.salesken.pallu.model.Subjects;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class SubjectsDetailsDto {

	@NotBlank
	@NotEmpty
	@NotNull
	private Semester semester;
	
	@NotBlank
	@NotEmpty
	@NotNull
	private Subjects subjects;
	
	@NotBlank
	@NotEmpty
	@NotNull
	@Max(value = 100, message = "Marks should not be more than 100")
	private double marks;
}
