package com.turkcell.OXIMusic.core.crossCuttingConcerns.mapping;

import org.modelmapper.ModelMapper;

public interface ModelMapperService {

	ModelMapper forResponse();

	ModelMapper forRequest();
}
