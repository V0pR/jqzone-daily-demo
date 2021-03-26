package com.core.controller;

import com.core.domain.VersionControl;
import com.core.service.VersionControlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author v0pr
 */
@RestController("versionControlController")
@RequestMapping("version-control")
public class VersionControlController {

    @Autowired
    private VersionControlService versionControlService;


    /**
     * 版本控制
     * @return
     */
    @GetMapping(value = "/find-version-control-list",produces = "application/json")
    public List<VersionControl> findVersionControlList(){
       return versionControlService.findVersionControlList();
    }

}
