package model;

import graphic.Position;

/**
 * すべてのゲームに登場するオブジェクトの抽象クラス
 * @author higuchi-dev
 *
 */
public abstract class GameObject {
	protected Position position;

	public GameObject(Position position) {
		this.position = position;
	}
}
