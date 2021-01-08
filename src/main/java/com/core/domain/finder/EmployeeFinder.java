package com.core.domain.finder;

import com.core.common.exception.BizException;
import com.core.domain.Employee;
import com.core.domain.query.QEmployee;
import io.ebean.Finder;

import java.util.Optional;

/**
 * @author wangj
 * @version 1.0
 * @Title: UserFinder
 * @Package com.core.domain.finder
 * @Description: TODO
 * @date 2020/3/17 22:40
 */
public class EmployeeFinder extends Finder<Long, Employee> {
    public EmployeeFinder() {
        super(Employee.class);
    }

    public EmployeeFinder(String databaseName) {
        super(Employee.class, databaseName);
    }

    public QEmployee queryBean() {
        return new QEmployee(db());
    }

    public Employee findByAccount(String account) {
        Optional<Employee> optional = this.queryBean()
                .where()
                .account.eq(account)
                .findOneOrEmpty();
        if (!optional.isPresent()){
            throw new BizException("employee does not exist");
        }
        return optional.get();
    }
}
