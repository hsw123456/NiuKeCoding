package cn.itcast.oa.service;

import cn.itcast.oa.base.DaoSupport;
import cn.itcast.oa.domain.Forum;

public interface ForumService extends DaoSupport<Forum>{
	
	//上移，最上面的不上移
	void moveUp(Long id);
	//下移，最下面的不下移
	void moveDown(Long id);


}
