package com.core.service.impl;

import com.core.domain.VersionControl;
import com.core.service.VersionControlService;
import io.ebean.DB;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author v0pr
 */
@Service("versionControlService")
public class VersionControlServiceImpl implements VersionControlService {

    @Override
    public List<VersionControl> findVersionControlList() {
        return DB.find(VersionControl.class)
                .findList();
    }
}
