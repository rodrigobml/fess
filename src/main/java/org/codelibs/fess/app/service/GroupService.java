/*
 * Copyright 2009-2015 the CodeLibs Project and the Others.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */

package org.codelibs.fess.app.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.codelibs.core.beans.util.BeanUtil;
import org.codelibs.fess.Constants;
import org.codelibs.fess.app.pager.GroupPager;
import org.codelibs.fess.es.cbean.GroupCB;
import org.codelibs.fess.es.exbhv.GroupBhv;
import org.codelibs.fess.es.exentity.Group;
import org.dbflute.cbean.result.PagingResultBean;

public class GroupService implements Serializable {

    private static final long serialVersionUID = 1L;

    @Resource
    protected GroupBhv groupBhv;

    public List<Group> getGroupList(final GroupPager groupPager) {

        final PagingResultBean<Group> groupList = groupBhv.selectPage(cb -> {
            cb.paging(groupPager.getPageSize(), groupPager.getCurrentPageNumber());
            setupListCondition(cb, groupPager);
        });

        // update pager
        BeanUtil.copyBeanToBean(groupList, groupPager, option -> option.include(Constants.PAGER_CONVERSION_RULE));
        groupPager.setPageNumberList(groupList.pageRange(op -> {
            op.rangeSize(5);
        }).createPageNumberList());

        return groupList;
    }

    public Group getGroup(final Map<String, String> keys) {
        final Group group = groupBhv.selectEntity(cb -> {
            cb.query().docMeta().setId_Equal(keys.get("id"));
            setupEntityCondition(cb, keys);
        }).orElse(null);//TODO
        if (group == null) {
            // TODO exception?
            return null;
        }

        return group;
    }

    public void store(final Group group) {
        setupStoreCondition(group);

        groupBhv.insertOrUpdate(group, op -> {
            op.setRefresh(true);
        });

    }

    public void delete(final Group group) {
        setupDeleteCondition(group);

        groupBhv.delete(group, op -> {
            op.setRefresh(true);
        });

    }

    protected void setupListCondition(final GroupCB cb, final GroupPager groupPager) {
        if (groupPager.id != null) {
            cb.query().docMeta().setId_Equal(groupPager.id);
        }
        // TODO Long, Integer, String supported only.

        // setup condition
        cb.query().addOrderBy_Name_Asc();

        // search

    }

    protected void setupEntityCondition(final GroupCB cb, final Map<String, String> keys) {

        // setup condition

    }

    protected void setupStoreCondition(final Group group) {

        // setup condition

    }

    protected void setupDeleteCondition(final Group group) {

        // setup condition

    }

    public List<Group> getAvailableGroupList() {
        return groupBhv.selectList(cb -> {
            cb.query().matchAll();
        });
    }

}
