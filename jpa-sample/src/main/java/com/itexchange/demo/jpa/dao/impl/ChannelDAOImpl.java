package com.itexchange.demo.jpa.dao.impl;

import javax.persistence.Query;

import com.itexchange.demo.jpa.dao.BaseDAO;
import com.itexchange.demo.jpa.dao.ChannelDAO;
import com.itexchange.demo.jpa.domain.Channel;
import com.itexchange.demo.jpa.exception.ObjectNotFoundException;

public class ChannelDAOImpl extends BaseDAO implements ChannelDAO{

	@Override
	public Channel findByChannelId(String channelId) throws ObjectNotFoundException {
		String strQuery = "SELECT ch FROM " + getEntityName() + " ch WHERE ch.id = :id";
		Query query = em.createQuery(strQuery);
		query.setParameter("id", channelId);
		Channel channel = (Channel) query.getSingleResult();
		return channel;
	}

	@Override
	public Channel save(Channel channel) {
		em.getTransaction().begin();
		em.persist(channel);
		em.getTransaction().commit();
		return channel;
	}

	@Override
	public Channel update(Channel channel) throws ObjectNotFoundException {
		return null;
	}

	@Override
	public void delete(Channel channel) throws ObjectNotFoundException {
	}
	
	@Override
	protected String getEntityName() {
		return Channel.class.getName();
	}

}
