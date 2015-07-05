package org.codelibs.fess.es.bsbhv;

import java.util.Map;

import org.codelibs.fess.es.bsentity.AbstractEntity;
import org.codelibs.fess.es.bsentity.AbstractEntity.RequestOptionCall;
import org.codelibs.fess.es.bsentity.dbmeta.ScheduledJobDbm;
import org.codelibs.fess.es.cbean.ScheduledJobCB;
import org.codelibs.fess.es.exentity.ScheduledJob;
import org.dbflute.Entity;
import org.dbflute.bhv.readable.CBCall;
import org.dbflute.cbean.ConditionBean;
import org.dbflute.cbean.result.ListResultBean;
import org.dbflute.cbean.result.PagingResultBean;
import org.dbflute.exception.IllegalBehaviorStateException;
import org.dbflute.optional.OptionalEntity;
import org.elasticsearch.action.delete.DeleteRequestBuilder;
import org.elasticsearch.action.index.IndexRequestBuilder;

/**
 * @author FreeGen
 */
public abstract class BsScheduledJobBhv extends AbstractBehavior<ScheduledJob, ScheduledJobCB> {

    @Override
    public String asTableDbName() {
        return "scheduled_job";
    }

    @Override
    protected String asIndexEsName() {
        return ".fess_config";
    }

    @Override
    public ScheduledJobDbm asDBMeta() {
        return ScheduledJobDbm.getInstance();
    }

    @Override
    protected <RESULT extends ScheduledJob> RESULT createEntity(Map<String, Object> source, Class<? extends RESULT> entityType) {
        try {
            final RESULT result = entityType.newInstance();
            result.setAvailable((Boolean) source.get("available"));
            result.setCrawler((String) source.get("crawler"));
            result.setCreatedBy((String) source.get("createdBy"));
            result.setCreatedTime((Long) source.get("createdTime"));
            result.setCronExpression((String) source.get("cronExpression"));
            result.setId((String) source.get("id"));
            result.setJobLogging((Boolean) source.get("jobLogging"));
            result.setName((String) source.get("name"));
            result.setScriptData((String) source.get("scriptData"));
            result.setScriptType((String) source.get("scriptType"));
            result.setSortOrder((Integer) source.get("sortOrder"));
            result.setTarget((String) source.get("target"));
            result.setUpdatedBy((String) source.get("updatedBy"));
            result.setUpdatedTime((Long) source.get("updatedTime"));
            return result;
        } catch (InstantiationException | IllegalAccessException e) {
            final String msg = "Cannot create a new instance: " + entityType.getName();
            throw new IllegalBehaviorStateException(msg, e);
        }
    }

    public int selectCount(CBCall<ScheduledJobCB> cbLambda) {
        return facadeSelectCount(createCB(cbLambda));
    }

    public OptionalEntity<ScheduledJob> selectEntity(CBCall<ScheduledJobCB> cbLambda) {
        return facadeSelectEntity(createCB(cbLambda));
    }

    protected OptionalEntity<ScheduledJob> facadeSelectEntity(ScheduledJobCB cb) {
        return doSelectOptionalEntity(cb, typeOfSelectedEntity());
    }

    protected <ENTITY extends ScheduledJob> OptionalEntity<ENTITY> doSelectOptionalEntity(ScheduledJobCB cb, Class<? extends ENTITY> tp) {
        return createOptionalEntity(doSelectEntity(cb, tp), cb);
    }

    @Override
    public ScheduledJobCB newConditionBean() {
        return new ScheduledJobCB();
    }

    @Override
    protected Entity doReadEntity(ConditionBean cb) {
        return facadeSelectEntity(downcast(cb)).orElse(null);
    }

    public ScheduledJob selectEntityWithDeletedCheck(CBCall<ScheduledJobCB> cbLambda) {
        return facadeSelectEntityWithDeletedCheck(createCB(cbLambda));
    }

    public OptionalEntity<ScheduledJob> selectByPK(String id) {
        return facadeSelectByPK(id);
    }

    protected OptionalEntity<ScheduledJob> facadeSelectByPK(String id) {
        return doSelectOptionalByPK(id, typeOfSelectedEntity());
    }

    protected <ENTITY extends ScheduledJob> ENTITY doSelectByPK(String id, Class<? extends ENTITY> tp) {
        return doSelectEntity(xprepareCBAsPK(id), tp);
    }

    protected ScheduledJobCB xprepareCBAsPK(String id) {
        assertObjectNotNull("id", id);
        return newConditionBean().acceptPK(id);
    }

    protected <ENTITY extends ScheduledJob> OptionalEntity<ENTITY> doSelectOptionalByPK(String id, Class<? extends ENTITY> tp) {
        return createOptionalEntity(doSelectByPK(id, tp), id);
    }

    @Override
    protected Class<? extends ScheduledJob> typeOfSelectedEntity() {
        return ScheduledJob.class;
    }

    @Override
    protected Class<ScheduledJob> typeOfHandlingEntity() {
        return ScheduledJob.class;
    }

    @Override
    protected Class<ScheduledJobCB> typeOfHandlingConditionBean() {
        return ScheduledJobCB.class;
    }

    public ListResultBean<ScheduledJob> selectList(CBCall<ScheduledJobCB> cbLambda) {
        return facadeSelectList(createCB(cbLambda));
    }

    public PagingResultBean<ScheduledJob> selectPage(CBCall<ScheduledJobCB> cbLambda) {
        // TODO same?
        return (PagingResultBean<ScheduledJob>) facadeSelectList(createCB(cbLambda));
    }

    public void insert(ScheduledJob entity) {
        doInsert(entity, null);
    }

    public void insert(ScheduledJob entity, RequestOptionCall<IndexRequestBuilder> opLambda) {
        if (entity instanceof AbstractEntity) {
            entity.asDocMeta().indexOption(opLambda);
        }
        doInsert(entity, null);
    }

    public void update(ScheduledJob entity) {
        doUpdate(entity, null);
    }

    public void update(ScheduledJob entity, RequestOptionCall<IndexRequestBuilder> opLambda) {
        if (entity instanceof AbstractEntity) {
            entity.asDocMeta().indexOption(opLambda);
        }
        doUpdate(entity, null);
    }

    public void insertOrUpdate(ScheduledJob entity) {
        doInsertOrUpdate(entity, null, null);
    }

    public void insertOrUpdate(ScheduledJob entity, RequestOptionCall<IndexRequestBuilder> opLambda) {
        if (entity instanceof AbstractEntity) {
            entity.asDocMeta().indexOption(opLambda);
        }
        doInsertOrUpdate(entity, null, null);
    }

    public void delete(ScheduledJob entity) {
        doDelete(entity, null);
    }

    public void delete(ScheduledJob entity, RequestOptionCall<DeleteRequestBuilder> opLambda) {
        if (entity instanceof AbstractEntity) {
            entity.asDocMeta().deleteOption(opLambda);
        }
        doDelete(entity, null);
    }

    // TODO create, modify, remove
}