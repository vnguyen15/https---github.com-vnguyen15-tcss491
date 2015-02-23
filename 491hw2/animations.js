
// Main space-craft animation
function Animation(spriteSheet, startX, startY, frameWidth, frameHeight, frameDuration, frames, loop, reverse) {
    this.spriteSheet = spriteSheet;
    this.startX = startX;
    this.startY = startY;
    this.frameWidth = frameWidth;
    this.frameDuration = frameDuration;
    this.frameHeight = frameHeight;
    this.frames = frames;
    this.totalTime = frameDuration * frames;
    this.elapsedTime = 0;
    this.loop = loop;
    this.reverse = reverse;
    this.action = 0;
}

Animation.prototype.drawFrame = function (tick, ctx, x, y, scaleBy, type, hpBar) { // wall arg added ???
    var scaleBy = scaleBy || 1;
    var frame = this.currentFrame();
    this.elapsedTime += tick;
    if (this.loop) {
        if (this.isDone()) {
            this.elapsedTime = 0;
        }
    } else if (this.isDone()) {
        return;
    }
    var index = 0;
    var vindex = 0;


    //frame = 7 - this.currentFrame();
    //index = frame % 8;
    //vindex = Math.floor(frame / 8);
    if (type === 1) {
        if (hpBar === 0)
            frame = 0;
        else if (hpBar === 1)
            frame = 1;
        else if (hpBar === 2)
            frame = 2;
        else if (hpBar === 3) frame = 3;
        else if (hpBar === 4) frame = 4;
        else if (hpBar === 5) frame = 5;
        else frame = 6;

        index = frame % 7;
        vindex = Math.floor(frame / 7);
    } else {
        index = frame % 3;
        vindex = Math.floor(frame / 3);
    }

    var locX = x;
    var locY = y;

    var offset = vindex === 0 ? this.startX : 0;
    
    //ctx.save(); 
    //ctx.rotate(3);
    ctx.drawImage(this.spriteSheet,
                  index * this.frameWidth + offset, vindex * this.frameHeight + this.startY,  // source from sheet
                  this.frameWidth, this.frameHeight,
                  locX, locY,
                  this.frameWidth * scaleBy,
                  this.frameHeight * scaleBy);
  //  ctx.restore();
}

Animation.prototype.currentFrame = function () {
    return Math.floor(this.elapsedTime / this.frameDuration);
}

Animation.prototype.isDone = function () {
    return (this.elapsedTime >= this.totalTime);
}

// Flash bullet animation
function FlashAnimation(spriteSheet, startX, startY, frameWidth, frameHeight, frameDuration, frames, loop, reverse) {
    this.spriteSheet = spriteSheet;
    this.startX = startX;
    this.startY = startY;
    this.frameWidth = frameWidth;
    this.frameDuration = frameDuration;
    this.frameHeight = frameHeight;
    this.frames = frames;
    this.totalTime = frameDuration * frames;
    this.elapsedTime = 0;
    this.loop = loop;
    this.reverse = reverse;
    this.action = 0;
}

FlashAnimation.prototype.drawFrame = function (tick, ctx, x, y, scaleBy) { 
  
    var scaleBy = scaleBy || 1;
    this.elapsedTime += tick;
    if (this.loop) {
        if (this.isDone()) {
            this.elapsedTime = 0;
        }
    } else if (this.isDone()) {
        return;
    }
    var index = 0;
    var vindex = 0;
    frame = this.currentFrame();
    index = frame % 6;
    vindex = Math.floor(frame / 6);

    var locX = x;
    var locY = y;
    var offset = vindex === 0 ? this.startX : 0;
    ctx.drawImage(this.spriteSheet,
                  index * this.frameWidth + offset, vindex * this.frameHeight + this.startY,  // source from sheet
                  this.frameWidth, this.frameHeight,
                  locX, locY,
                  this.frameWidth * scaleBy,
                  this.frameHeight * scaleBy);
}

FlashAnimation.prototype.currentFrame = function () {
    return Math.floor(this.elapsedTime / this.frameDuration);
}

FlashAnimation.prototype.isDone = function () {
    return (this.elapsedTime >= this.totalTime);
}

function Background(game) {
    this.animation = new Animation(ASSET_MANAGER.getAsset("./img/bg.png"), 0, 0, 768, 520, 100, 1, true, false);


    Entity.call(this, game, 0, 0);
    this.radius = 200;
}

function Background(game) {
    this.animation = new Animation(ASSET_MANAGER.getAsset("./img/bg.png"), 0, 0, 768, 520, 100, 1, true, false);

    Entity.call(this, game, 0, 0);
}

// animation for enemies spaceships
function EnemyAnimation(spriteSheet, startX, startY, frameWidth, frameHeight, frameDuration, frames, loop, reverse) {
    this.spriteSheet = spriteSheet;
    this.startX = startX;
    this.startY = startY;
    this.frameWidth = frameWidth;
    this.frameDuration = frameDuration;
    this.frameHeight = frameHeight;
    this.frames = frames;
    this.totalTime = frameDuration * frames;
    this.elapsedTime = 0;
    this.loop = loop;
    this.reverse = reverse;
    this.action = 0;
}


EnemyAnimation.prototype.drawFrame = function (tick, ctx, x, y, scaleBy, alive) { // wall arg added ???

    var scaleBy = scaleBy || 1;
    var frame = this.currentFrame();
    this.elapsedTime += tick;
    if (this.loop) {
        if (this.isDone()) {
            this.elapsedTime = 0;
        }
    } else if (this.isDone()) {
        return;
    }
    var index = 0;
    var vindex = 0;


    frame = this.currentFrame();
    if (!alive) {
        //frame = 13 + this.currentFrame();
        index = frame % 18;
        vindex = Math.floor(frame / 18);

    } else {
        index = frame % 1;
        vindex = Math.floor(frame / 1);
    }

    var locX = x;
    var locY = y;
    var offset = vindex === 0 ? this.startX : 0;

   // ctx.save();
   // ctx.rotate(3);
    ctx.drawImage(this.spriteSheet,
                  index * this.frameWidth + offset , vindex * this.frameHeight + this.startY ,  // source from sheet
                  this.frameWidth, this.frameHeight,
                  locX, locY,
                  this.frameWidth * scaleBy,
                  this.frameHeight * scaleBy);
  //  ctx.restore();
}

EnemyAnimation.prototype.currentFrame = function () {
    return Math.floor(this.elapsedTime / this.frameDuration);
}

EnemyAnimation.prototype.isDone = function () {
    return (this.elapsedTime >= this.totalTime);
}

//
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// rokes animation
function RocksAnimation(spriteSheet, startX, startY, frameWidth, frameHeight, frameDuration, frames, loop, reverse) {
    this.spriteSheet = spriteSheet;
    this.startX = startX;
    this.startY = startY;
    this.frameWidth = frameWidth;
    this.frameDuration = frameDuration;
    this.frameHeight = frameHeight;
    this.frames = frames;
    this.totalTime = frameDuration * frames;
    this.elapsedTime = 0;
    this.loop = loop;
    this.reverse = reverse;
}

RocksAnimation.prototype.drawFrame = function (tick, ctx, x, y) { // wall arg added ???
    var frame = this.currentFrame();
    this.elapsedTime += tick;
    if (this.loop) {
        if (this.isDone()) {
            this.elapsedTime = 0;
        }
    } else if (this.isDone()) {
        return;
    }
    var index = 0;
    var vindex = 0;


    frame = 56 - this.currentFrame();
    index = frame % 7;
    vindex = Math.floor(frame / 8);

    var locX = x;
    var locY = y;

    var offset = vindex === 0 ? this.startX : 0;

    ctx.drawImage(this.spriteSheet,
                  index * this.frameWidth, vindex * this.frameHeight + this.startY,  // source from sheet
                  this.frameWidth, this.frameHeight,
                  locX, locY,
                  this.frameWidth,
                  this.frameHeight);
}

RocksAnimation.prototype.currentFrame = function () {
    return Math.floor(this.elapsedTime / this.frameDuration);
}

RocksAnimation.prototype.isDone = function () {
    return (this.elapsedTime >= this.totalTime);
}


// Boss animation
function AnimationB(spriteSheet, startX, startY, frameWidth, frameHeight,
		           frameDuration, frames, loop, reverse) {
    this.spriteSheet = spriteSheet;
    this.startX = startX;
    this.startY = startY;
    this.frameWidth = frameWidth;
    this.frameDuration = frameDuration;
    this.frameHeight = frameHeight;
    this.frames = frames;
    this.totalTime = frameDuration * frames;
    this.elapsedTime = 0;
    this.loop = loop;
    this.reverse = reverse;
}

AnimationB.prototype.drawFrame = function (tick, ctx, x, y, scaleBy) {
    var scaleBy = scaleBy || 1;
    this.elapsedTime += tick;
    if (this.loop) {
        if (this.isDone()) {
            this.elapsedTime = 0;
        }
    } else if (this.isDone()) {
        return;
    }
    var index = this.reverse ? this.frames - this.currentFrame() - 1 :
    	                       this.currentFrame();
    var vindex = 0;
    if ((index + 1) * this.frameWidth + this.startX > this.spriteSheet.width) {
        index -= Math.floor((this.spriteSheet.width - this.startX) / this.frameWidth);
        vindex++;
    }
    while ((index + 1) * this.frameWidth > this.spriteSheet.width) {
        index -= Math.floor(this.spriteSheet.width / this.frameWidth);
        vindex++;
    }

    var locX = x;
    var locY = y;
    var offset = vindex === 0 ? this.startX : 0;
    ctx.drawImage(this.spriteSheet,
                  index * this.frameWidth + offset, vindex * this.frameHeight +
                  this.startY,  // source from sheet
                  this.frameWidth, this.frameHeight,
                  locX, locY,
                  this.frameWidth * scaleBy,
                  this.frameHeight * scaleBy);
}

AnimationB.prototype.currentFrame = function () {
    return Math.floor(this.elapsedTime / this.frameDuration);
}

AnimationB.prototype.isDone = function () {
    return (this.elapsedTime >= this.totalTime);
}

// Animation for background
function AnimationBG(spriteSheet, startX, startY, frameWidth, frameHeight, frameDuration, frames, loop, reverse) {
    this.spriteSheet = spriteSheet;
    this.startX = startX;
    this.startY = startY;
    this.frameWidth = frameWidth;
    this.frameDuration = frameDuration;
    this.frameHeight = frameHeight;
    this.frames = frames;
    this.totalTime = frameDuration * frames;
    this.elapsedTime = 0;
    this.loop = loop;
    this.reverse = reverse;
    this.action = 0;
}


AnimationBG.prototype.drawFrame = function (tick, ctx, x, y, scaleBy) { // wall arg added ???

    var scaleBy = scaleBy || 1;
    var frame = this.currentFrame();
    this.elapsedTime += tick;
    if (this.loop) {
        if (this.isDone()) {
            this.elapsedTime = 0;
        }
    } else if (this.isDone()) {
        return;
    }
    var index = 0;
    var vindex = 0;


    frame = this.currentFrame();
    index = frame % 1;
    vindex = Math.floor(frame / 1);

    var locX = x;
    var locY = y;
    var offset = vindex === 0 ? this.startX : 0;

    ctx.drawImage(this.spriteSheet,
                  index * this.frameWidth + offset, vindex * this.frameHeight + this.startY,  // source from sheet
                  this.frameWidth, this.frameHeight,
                  locX, locY,
                  this.frameWidth * scaleBy,
                  this.frameHeight * scaleBy);
}

AnimationBG.prototype.currentFrame = function () {
    return Math.floor(this.elapsedTime / this.frameDuration);
}

AnimationBG.prototype.isDone = function () {
    return (this.elapsedTime >= this.totalTime);
}

// Fire ball bullet animation
function FireBallAnimation(spriteSheet, startX, startY, frameWidth, frameHeight, frameDuration, frames, loop, reverse) {
    this.spriteSheet = spriteSheet;
    this.startX = startX;
    this.startY = startY;
    this.frameWidth = frameWidth;
    this.frameDuration = frameDuration;
    this.frameHeight = frameHeight;
    this.frames = frames;
    this.totalTime = frameDuration * frames;
    this.elapsedTime = 0;
    this.loop = loop;
    this.reverse = reverse;
    this.action = 0;
}

FireBallAnimation.prototype.drawFrame = function (tick, ctx, x, y, scaleBy, type, explosion) {

    var scaleBy = scaleBy || 1;
    this.elapsedTime += tick;
    if (this.loop) {
        if (this.isDone()) {
            this.elapsedTime = 0;
        }
    } else if (this.isDone()) {
        return;
    }
    var index = 0;
    var vindex = 0;
    // pass current frame to rocket/explosion sprite
  //  this.game.entities[4].currentFrame = this.currentFrame();

    var frame = this.currentFrame();
    if (explosion) {
        // frame = 11 - this.currentFrame();
        //if (frame > 13) {
        //    frame = 25 - frame;
        //}
        index = frame % 25;
        vindex = Math.floor(frame / 25);

    } else if (type === 1) {
        index = frame % 6;
        vindex = Math.floor(frame / 6);
    } else {
        index = frame % 4;
        vindex = Math.floor(frame / 4);
    }

    var locX = x;
    var locY = y;
    var offset = vindex === 0 ? this.startX : 0;
    ctx.drawImage(this.spriteSheet,
                  index * this.frameWidth + offset, vindex * this.frameHeight + this.startY,  // source from sheet
                  this.frameWidth, this.frameHeight,
                  locX, locY,
                  this.frameWidth * scaleBy,
                  this.frameHeight * scaleBy);
}

FireBallAnimation.prototype.currentFrame = function () {
    return Math.floor(this.elapsedTime / this.frameDuration);
}

FireBallAnimation.prototype.isDone = function () {
    return (this.elapsedTime >= this.totalTime);
}