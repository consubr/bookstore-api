package br.com.davefernandes.bookstore.resources.exceptions;

import java.util.Date;

public class StandardError {

	private Long timestamp;
	private Date data;
	private Integer status;
	private String error;

	public StandardError() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StandardError(Long timestamp, Integer status, String error) {
		super();
		this.timestamp = timestamp;
		this.status = status;
		this.error = error;
	}

	public StandardError(Date data, Integer status, String error) {
		super();
		this.data = data;
		this.status = status;
		this.error = error;
	}

	public StandardError(Long timestamp, Date data, Integer status, String error) {
		super();
		this.timestamp = timestamp;
		this.data = data;
		this.status = status;
		this.error = error;
	}

	public Long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

}
