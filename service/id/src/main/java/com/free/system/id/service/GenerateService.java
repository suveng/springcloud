package com.free.system.id.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * description:
 * @author suwenguang
 * @version 1.0.0
 **/
@Service
public class GenerateService implements IGenerateService {

	@Autowired
	UniqueIdLogService uniqueIdLogService;


}
