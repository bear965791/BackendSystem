package member.dao;

import member.model.CoachBean;

public interface CoachDao {
	public CoachBean findByFk(int fk);
	
	public void updatPassAndChecked(CoachBean cb);
}
