package com.farmatodo.ticketmanagement.application.utlis;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponseUtils<T> {
	private String message;
	private T data;
	private Integer statusCode;
}
