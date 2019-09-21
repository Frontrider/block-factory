# Block Factory

This mod registers blocks and simple items based on files inside the
`block-factory` folder, inside the mc directory.

You can register a new block like 
this:`block-factory/blocks/<namespace>/<block-name>.json`

The current json format:
These are the default values, any of these fields can be omitted.

```
{
  //STONE, WOOD,METAL,GLASS,DIRT,SAND
  //more will be supported later, these are the included ones for the trial.
  "material": "STONE",
  //controls how the block should be rendered. Set it to TRANSPARENT if it's not a full block.
  "renderLayer": "SOLID",
  //set to false if nothing should spawn on it
  "canSpawnMobs":true,
  "isAir":false,
  //max 15, the amount of light that this block can emit.
  "lightLevel": 0,
  "isInvisible": false,
  "hardness": 1.0,
  //set it to false if the player should to collide with it.
  "isCollideable": true,
  //set to false if this block has no item.
  "hasItem": true,
  //weather or not this block should tick randomly, like leaves. 
  //this is here, so you can hook up things like the functions with the function API.
  "ticksRandomly":false,
  //NORMAl,STAIRS,SLAB,FENCE.
  //use fence for walls.
  "type":"NORMAl"
}
```

For an item put a json file under:
`block-factory/items/<namespace>/<item-name>.json`

Currently, you have to make it an empty json `{}`
