package com.advanced.proxy.common.service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ServiceImpl implements ServiceInterface {

    @Override
    public void save() {
        log.info("call save");
    }

    @Override
    public void find() {
        log.info("call find");
    }
}
