/*******************************************************************************
 * Copyright 2019 grondag
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License.  You may obtain a copy
 * of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations under
 * the License.
 ******************************************************************************/

package grondag.canvas.chunk;

import net.fabricmc.fabric.api.renderer.v1.material.BlendMode;

import grondag.canvas.chunk.occlusion.ChunkOcclusionGraphExt;

public interface ChunkRenderDataExt {
	void canvas_clear();

	void canvas_setNonEmpty(BlendMode blockRenderLayer);

	ChunkOcclusionGraphExt canvas_chunkVisibility();

	int[][] canvas_collectorState();

	void canvas_collectorState(int[][] state);
}