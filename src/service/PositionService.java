package service;

import java.util.ArrayList;

import model.Position;

public interface PositionService {

	public abstract Position validatePosition(int id);
	public abstract ArrayList<Position> getPositionByPositionId(int pos);
}
