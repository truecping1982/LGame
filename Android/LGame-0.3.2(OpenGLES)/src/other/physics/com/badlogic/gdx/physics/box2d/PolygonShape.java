package com.badlogic.gdx.physics.box2d;

import org.loon.framework.android.game.core.geom.Vector2f;

public class PolygonShape extends Shape {

	/**
	 * Constructs a new polygon
	 */
	public PolygonShape() {
		addr = newPolygonShape();
	}

	private native long newPolygonShape();

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Type getType() {
		return Type.Polygon;
	}

	/**
	 * Copy vertices. This assumes the vertices define a convex polygon. It is
	 * assumed that the exterior is the the right of each edge.
	 */
	public void set(Vector2f[] vertices) {
		int vertice_size = vertices.length * 2;
		float[] verts = new float[vertice_size];
		for (int i = 0, j = 0; i < vertice_size; i += 2, j++) {
			verts[i] = vertices[j].x;
			verts[i + 1] = vertices[j].y;
		}
		jniSet(addr, verts);
	}

	public void set(float[] vertice) {
		jniSet(addr, vertice);
	}

	private native void jniSet(long addr, float[] verts);

	/**
	 * Build vertices to represent an axis-aligned box.
	 * 
	 * @param hx
	 *            the half-width.
	 * @param hy
	 *            the half-height.
	 */
	public void setAsBox(float hx, float hy) {
		jniSetAsBox(addr, hx, hy);
	}

	private native void jniSetAsBox(long addr, float hx, float hy);

	/**
	 * Build vertices to represent an oriented box.
	 * 
	 * @param hx
	 *            the half-width.
	 * @param hy
	 *            the half-height.
	 * @param center
	 *            the center of the box in local coordinates.
	 * @param angle
	 *            the rotation of the box in local coordinates.
	 */
	public void setAsBox(float hx, float hy, Vector2f center, float angle) {
		jniSetAsBox(addr, hx, hy, center.x, center.y, angle);
	}

	private native void jniSetAsBox(long addr, float hx, float hy,
			float centerX, float centerY, float angle);

	/**
	 * Set this as a single edge.
	 */
	public void setAsEdge(Vector2f v1, Vector2f v2) {
		jniSetAsEdge(addr, v1.x, v1.y, v2.x, v2.y);
	}

	private native void jniSetAsEdge(long addr, float v1x, float v1y,
			float v2x, float v2y);

}
