package stark.coderaider.titan.treasure.core.dao;

import org.apache.ibatis.annotations.Mapper;
import stark.coderaider.titan.treasure.core.domain.entities.mysql.UserProfile;

@Mapper
public interface UserProfileMapper
{
    UserProfile getUserProfileByUserId(long userId);
    int insert(UserProfile userProfile);
}
