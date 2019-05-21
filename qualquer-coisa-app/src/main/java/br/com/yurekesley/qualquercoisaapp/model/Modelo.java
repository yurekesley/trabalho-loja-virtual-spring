package br.com.yurekesley.qualquercoisaapp.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import lombok.EqualsAndHashCode;

@JsonAutoDetect
@EqualsAndHashCode
public abstract class Modelo implements Serializable {

	private static final long serialVersionUID = 1L;

}
