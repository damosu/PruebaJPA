package com.itexchange.demo.jpa.dao;

import com.itexchange.demo.jpa.domain.Channel;
import com.itexchange.demo.jpa.exception.ObjectNotFoundException;

public interface ChannelDAO {

	Channel findByChannelId(String channelId) throws ObjectNotFoundException;
	
	Channel save(Channel channel);
	
	Channel update(Channel channel) throws ObjectNotFoundException;
	
	void delete(Channel channel)  throws ObjectNotFoundException;
}
