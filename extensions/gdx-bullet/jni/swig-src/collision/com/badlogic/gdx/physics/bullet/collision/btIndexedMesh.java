/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.12
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package com.badlogic.gdx.physics.bullet.collision;

import com.badlogic.gdx.physics.bullet.BulletBase;
import com.badlogic.gdx.physics.bullet.linearmath.*;
import com.badlogic.gdx.graphics.Mesh;
import com.badlogic.gdx.graphics.VertexAttribute;
import com.badlogic.gdx.graphics.VertexAttributes.Usage;
import com.badlogic.gdx.graphics.g3d.model.MeshPart;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.GdxRuntimeException;

public class btIndexedMesh extends BulletBase {
	private long swigCPtr;
	
	protected btIndexedMesh(final String className, long cPtr, boolean cMemoryOwn) {
		super(className, cPtr, cMemoryOwn);
		swigCPtr = cPtr;
	}
	
	/** Construct a new btIndexedMesh, normally you should not need this constructor it's intended for low-level usage. */ 
	public btIndexedMesh(long cPtr, boolean cMemoryOwn) {
		this("btIndexedMesh", cPtr, cMemoryOwn);
		construct();
	}
	
	@Override
	protected void reset(long cPtr, boolean cMemoryOwn) {
		if (!destroyed)
			destroy();
		super.reset(swigCPtr = cPtr, cMemoryOwn);
	}
	
	public static long getCPtr(btIndexedMesh obj) {
		return (obj == null) ? 0 : obj.swigCPtr;
	}

	@Override
	protected void finalize() throws Throwable {
		if (!destroyed)
			destroy();
		super.finalize();
	}

  @Override protected synchronized void delete() {
		if (swigCPtr != 0) {
			if (swigCMemOwn) {
				swigCMemOwn = false;
				CollisionJNI.delete_btIndexedMesh(swigCPtr);
			}
			swigCPtr = 0;
		}
		super.delete();
	}

	protected final static Array<btIndexedMesh> instances = new Array<btIndexedMesh>();
	protected static btIndexedMesh getInstance(final MeshPart meshPart) {
		final int n = instances.size;
		for (int i = 0; i < n; i++) {
			final btIndexedMesh mesh = instances.get(i);
			if (meshPart.equals(mesh.meshPart))
				return mesh;
		}
		return null;
	}
	
	/** Create or reuse a btIndexedMesh instance based on the specified {@link MeshPart}.
	 * Use {@link #release()} to release the mesh when it's no longer needed. */
	public static btIndexedMesh obtain(final MeshPart meshPart) {
		if (meshPart == null)
			throw new GdxRuntimeException("meshPart cannot be null");
		
		btIndexedMesh result = getInstance(meshPart);
		if (result == null) {
			result = new btIndexedMesh(meshPart);
			instances.add(result);
		}
		result.obtain();
		return result;
	}
	
	protected MeshPart meshPart;
	
	/** Construct a new btIndexedMesh based on the supplied {@link Mesh}
	 * The specified mesh must be indexed and triangulated and must outlive this btIndexedMesh.
	 * The buffers for the vertices and indices are shared amonst both. */
	public btIndexedMesh(final Mesh mesh) {
		this();
		set(mesh);
	}
	
	/** Construct a new btIndexedMesh based on the supplied {@link MeshPart}
	 * The specified mesh must be indexed and triangulated and must outlive this btIndexedMesh.
	 * The buffers for the vertices and indices are shared amonst both. */
	public btIndexedMesh(final MeshPart meshPart) {
		this();
		set(meshPart);
	}
	
	/** Construct a new btIndexedMesh based on the supplied {@link Mesh}
	 * The specified mesh must be indexed and triangulated and must outlive this btIndexedMesh.
	 * The buffers for the vertices and indices are shared amonst both. */
	public btIndexedMesh(final Mesh mesh, int offset, int count) {
		this();
		set(mesh, offset, count);
	}
	
	/** @return The {@link MeshPart} used to create or set this btIndexedMesh, may be null. */
	public MeshPart getMeshPart() {
		return meshPart;
	}
	
	/** Convenience method to set this btIndexedMesh to the specified {@link Mesh} 
	 * The specified mesh must be indexed and triangulated and must outlive this btIndexedMesh.
	 * The buffers for the vertices and indices are shared amonst both. */
	public void set(final Mesh mesh) {
		set(mesh, 0, mesh.getNumIndices());
	}

	/** Convenience method to set this btIndexedMesh to the specified {@link MeshPart} 
	 * The specified mesh must be indexed and triangulated and must outlive this btIndexedMesh.
	 * The buffers for the vertices and indices are shared amonst both. */
	public void set(final MeshPart meshPart) {
		if (meshPart.primitiveType != com.badlogic.gdx.graphics.GL10.GL_TRIANGLES)
			throw new com.badlogic.gdx.utils.GdxRuntimeException("Mesh must be indexed and triangulated");
		set(meshPart.mesh, meshPart.indexOffset, meshPart.numVertices);
		this.meshPart = meshPart;
	}

	/** Convenience method to set this btIndexedMesh to the specified {@link Mesh} 
	 * The specified mesh must be indexed and triangulated and must outlive this btIndexedMesh.
	 * The buffers for the vertices and indices are shared amonst both. */
	public void set(final Mesh mesh, int offset, int count) {
		if ((count <= 0) || ((count % 3) != 0))
			throw new com.badlogic.gdx.utils.GdxRuntimeException("Mesh must be indexed and triangulated");

		VertexAttribute posAttr = mesh.getVertexAttribute(Usage.Position);
		
		if (posAttr == null)
			throw new com.badlogic.gdx.utils.GdxRuntimeException("Mesh doesn't have a position attribute");
		
		setVertices(mesh.getVerticesBuffer(), mesh.getVertexSize(), mesh.getNumVertices(), posAttr.offset);
		setIndices(mesh.getIndicesBuffer(), offset, count);
		
		meshPart = null;
	}

  public void setNumTriangles(int value) {
    CollisionJNI.btIndexedMesh_numTriangles_set(swigCPtr, this, value);
  }

  public int getNumTriangles() {
    return CollisionJNI.btIndexedMesh_numTriangles_get(swigCPtr, this);
  }

  public void setTriangleIndexBase(java.nio.ByteBuffer value) {
    assert value.isDirect() : "Buffer must be allocated direct.";
    {
      CollisionJNI.btIndexedMesh_triangleIndexBase_set(swigCPtr, this, value);
    }
  }

  public java.nio.ByteBuffer getTriangleIndexBase() {
    return CollisionJNI.btIndexedMesh_triangleIndexBase_get(swigCPtr, this);
}

  public void setTriangleIndexStride(int value) {
    CollisionJNI.btIndexedMesh_triangleIndexStride_set(swigCPtr, this, value);
  }

  public int getTriangleIndexStride() {
    return CollisionJNI.btIndexedMesh_triangleIndexStride_get(swigCPtr, this);
  }

  public void setNumVertices(int value) {
    CollisionJNI.btIndexedMesh_numVertices_set(swigCPtr, this, value);
  }

  public int getNumVertices() {
    return CollisionJNI.btIndexedMesh_numVertices_get(swigCPtr, this);
  }

  public void setVertexBase(java.nio.ByteBuffer value) {
    assert value.isDirect() : "Buffer must be allocated direct.";
    {
      CollisionJNI.btIndexedMesh_vertexBase_set(swigCPtr, this, value);
    }
  }

  public java.nio.ByteBuffer getVertexBase() {
    return CollisionJNI.btIndexedMesh_vertexBase_get(swigCPtr, this);
}

  public void setVertexStride(int value) {
    CollisionJNI.btIndexedMesh_vertexStride_set(swigCPtr, this, value);
  }

  public int getVertexStride() {
    return CollisionJNI.btIndexedMesh_vertexStride_get(swigCPtr, this);
  }

  public void setIndexType(int value) {
    CollisionJNI.btIndexedMesh_indexType_set(swigCPtr, this, value);
  }

  public int getIndexType() {
    return CollisionJNI.btIndexedMesh_indexType_get(swigCPtr, this);
  }

  public void setVertexType(int value) {
    CollisionJNI.btIndexedMesh_vertexType_set(swigCPtr, this, value);
  }

  public int getVertexType() {
    return CollisionJNI.btIndexedMesh_vertexType_get(swigCPtr, this);
  }

  public btIndexedMesh() {
    this(CollisionJNI.new_btIndexedMesh(), true);
  }

  public void setTriangleIndexBase(java.nio.ShortBuffer data) {
    assert data.isDirect() : "Buffer must be allocated direct.";
    {
      CollisionJNI.btIndexedMesh_setTriangleIndexBase(swigCPtr, this, data);
    }
  }

  public void setVertexBase(java.nio.FloatBuffer data) {
    assert data.isDirect() : "Buffer must be allocated direct.";
    {
      CollisionJNI.btIndexedMesh_setVertexBase(swigCPtr, this, data);
    }
  }

  public void setVertices(java.nio.FloatBuffer vertices, int sizeInBytesOfEachVertex, int vertexCount, int positionOffsetInBytes) {
    assert vertices.isDirect() : "Buffer must be allocated direct.";
    {
      CollisionJNI.btIndexedMesh_setVertices(swigCPtr, this, vertices, sizeInBytesOfEachVertex, vertexCount, positionOffsetInBytes);
    }
  }

  public void setIndices(java.nio.ShortBuffer indices, int indexOffset, int indexCount) {
    assert indices.isDirect() : "Buffer must be allocated direct.";
    {
      CollisionJNI.btIndexedMesh_setIndices(swigCPtr, this, indices, indexOffset, indexCount);
    }
  }

}
