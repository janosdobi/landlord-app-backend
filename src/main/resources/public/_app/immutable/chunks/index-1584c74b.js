function w(){}const ct=t=>t;function lt(t,e){for(const n in e)t[n]=e[n];return t}function Q(t){return t()}function I(){return Object.create(null)}function v(t){t.forEach(Q)}function T(t){return typeof t=="function"}function Lt(t,e){return t!=t?e==e:t!==e||t&&typeof t=="object"||typeof t=="function"}function ot(t){return Object.keys(t).length===0}function ut(t,...e){if(t==null)return w;const n=t.subscribe(...e);return n.unsubscribe?()=>n.unsubscribe():n}function Rt(t,e,n){t.$$.on_destroy.push(ut(e,n))}function zt(t,e,n,i){if(t){const r=W(t,e,n,i);return t[0](r)}}function W(t,e,n,i){return t[1]&&i?lt(n.ctx.slice(),t[1](i(e))):n.ctx}function Bt(t,e,n,i){if(t[2]&&i){const r=t[2](i(n));if(e.dirty===void 0)return r;if(typeof r=="object"){const u=[],s=Math.max(e.dirty.length,r.length);for(let c=0;c<s;c+=1)u[c]=e.dirty[c]|r[c];return u}return e.dirty|r}return e.dirty}function Tt(t,e,n,i,r,u){if(r){const s=W(e,n,i,u);t.p(s,r)}}function qt(t){if(t.ctx.length>32){const e=[],n=t.ctx.length/32;for(let i=0;i<n;i++)e[i]=-1;return e}return-1}const U=typeof window<"u";let at=U?()=>window.performance.now():()=>Date.now(),q=U?t=>requestAnimationFrame(t):w;const $=new Set;function V(t){$.forEach(e=>{e.c(t)||($.delete(e),e.f())}),$.size!==0&&q(V)}function ft(t){let e;return $.size===0&&q(V),{promise:new Promise(n=>{$.add(e={c:t,f:n})}),abort(){$.delete(e)}}}let P=!1;function _t(){P=!0}function dt(){P=!1}function ht(t,e,n,i){for(;t<e;){const r=t+(e-t>>1);n(r)<=i?t=r+1:e=r}return t}function mt(t){if(t.hydrate_init)return;t.hydrate_init=!0;let e=t.childNodes;if(t.nodeName==="HEAD"){const l=[];for(let o=0;o<e.length;o++){const _=e[o];_.claim_order!==void 0&&l.push(_)}e=l}const n=new Int32Array(e.length+1),i=new Int32Array(e.length);n[0]=-1;let r=0;for(let l=0;l<e.length;l++){const o=e[l].claim_order,_=(r>0&&e[n[r]].claim_order<=o?r+1:ht(1,r,h=>e[n[h]].claim_order,o))-1;i[l]=n[_]+1;const a=_+1;n[a]=l,r=Math.max(a,r)}const u=[],s=[];let c=e.length-1;for(let l=n[r]+1;l!=0;l=i[l-1]){for(u.push(e[l-1]);c>=l;c--)s.push(e[c]);c--}for(;c>=0;c--)s.push(e[c]);u.reverse(),s.sort((l,o)=>l.claim_order-o.claim_order);for(let l=0,o=0;l<s.length;l++){for(;o<u.length&&s[l].claim_order>=u[o].claim_order;)o++;const _=o<u.length?u[o]:null;t.insertBefore(s[l],_)}}function pt(t,e){t.appendChild(e)}function X(t){if(!t)return document;const e=t.getRootNode?t.getRootNode():t.ownerDocument;return e&&e.host?e:t.ownerDocument}function yt(t){const e=Z("style");return gt(X(t),e),e.sheet}function gt(t,e){return pt(t.head||t,e),e.sheet}function bt(t,e){if(P){for(mt(t),(t.actual_end_child===void 0||t.actual_end_child!==null&&t.actual_end_child.parentNode!==t)&&(t.actual_end_child=t.firstChild);t.actual_end_child!==null&&t.actual_end_child.claim_order===void 0;)t.actual_end_child=t.actual_end_child.nextSibling;e!==t.actual_end_child?(e.claim_order!==void 0||e.parentNode!==t)&&t.insertBefore(e,t.actual_end_child):t.actual_end_child=e.nextSibling}else(e.parentNode!==t||e.nextSibling!==null)&&t.appendChild(e)}function Ft(t,e,n){P&&!n?bt(t,e):(e.parentNode!==t||e.nextSibling!=n)&&t.insertBefore(e,n||null)}function Y(t){t.parentNode&&t.parentNode.removeChild(t)}function Z(t){return document.createElement(t)}function F(t){return document.createTextNode(t)}function Ht(){return F(" ")}function It(){return F("")}function Gt(t,e,n,i){return t.addEventListener(e,n,i),()=>t.removeEventListener(e,n,i)}function Jt(t){return function(e){return e.preventDefault(),t.call(this,e)}}function Kt(t,e,n){n==null?t.removeAttribute(e):t.getAttribute(e)!==n&&t.setAttribute(e,n)}function xt(t){return Array.from(t.childNodes)}function $t(t){t.claim_info===void 0&&(t.claim_info={last_index:0,total_claimed:0})}function tt(t,e,n,i,r=!1){$t(t);const u=(()=>{for(let s=t.claim_info.last_index;s<t.length;s++){const c=t[s];if(e(c)){const l=n(c);return l===void 0?t.splice(s,1):t[s]=l,r||(t.claim_info.last_index=s),c}}for(let s=t.claim_info.last_index-1;s>=0;s--){const c=t[s];if(e(c)){const l=n(c);return l===void 0?t.splice(s,1):t[s]=l,r?l===void 0&&t.claim_info.last_index--:t.claim_info.last_index=s,c}}return i()})();return u.claim_order=t.claim_info.total_claimed,t.claim_info.total_claimed+=1,u}function wt(t,e,n,i){return tt(t,r=>r.nodeName===e,r=>{const u=[];for(let s=0;s<r.attributes.length;s++){const c=r.attributes[s];n[c.name]||u.push(c.name)}u.forEach(s=>r.removeAttribute(s))},()=>i(e))}function Qt(t,e,n){return wt(t,e,n,Z)}function vt(t,e){return tt(t,n=>n.nodeType===3,n=>{const i=""+e;if(n.data.startsWith(i)){if(n.data.length!==i.length)return n.splitText(i.length)}else n.data=i},()=>F(e),!0)}function Wt(t){return vt(t," ")}function Ut(t,e){e=""+e,t.wholeText!==e&&(t.data=e)}function Vt(t,e,n,i){n===null?t.style.removeProperty(e):t.style.setProperty(e,n,i?"important":"")}function Xt(t,e,n){t.classList[n?"add":"remove"](e)}function et(t,e,{bubbles:n=!1,cancelable:i=!1}={}){const r=document.createEvent("CustomEvent");return r.initCustomEvent(t,n,i,e),r}function Yt(t,e){return new t(e)}const j=new Map;let M=0;function Et(t){let e=5381,n=t.length;for(;n--;)e=(e<<5)-e^t.charCodeAt(n);return e>>>0}function Nt(t,e){const n={stylesheet:yt(e),rules:{}};return j.set(t,n),n}function G(t,e,n,i,r,u,s,c=0){const l=16.666/i;let o=`{
`;for(let y=0;y<=1;y+=l){const g=e+(n-e)*u(y);o+=y*100+`%{${s(g,1-g)}}
`}const _=o+`100% {${s(n,1-n)}}
}`,a=`__svelte_${Et(_)}_${c}`,h=X(t),{stylesheet:f,rules:d}=j.get(h)||Nt(h,t);d[a]||(d[a]=!0,f.insertRule(`@keyframes ${a} ${_}`,f.cssRules.length));const m=t.style.animation||"";return t.style.animation=`${m?`${m}, `:""}${a} ${i}ms linear ${r}ms 1 both`,M+=1,a}function kt(t,e){const n=(t.style.animation||"").split(", "),i=n.filter(e?u=>u.indexOf(e)<0:u=>u.indexOf("__svelte")===-1),r=n.length-i.length;r&&(t.style.animation=i.join(", "),M-=r,M||At())}function At(){q(()=>{M||(j.forEach(t=>{const{ownerNode:e}=t.stylesheet;e&&Y(e)}),j.clear())})}let k;function N(t){k=t}function H(){if(!k)throw new Error("Function called outside component initialization");return k}function Zt(t){H().$$.on_mount.push(t)}function te(t){H().$$.after_update.push(t)}function ee(){const t=H();return(e,n,{cancelable:i=!1}={})=>{const r=t.$$.callbacks[e];if(r){const u=et(e,n,{cancelable:i});return r.slice().forEach(s=>{s.call(t,u)}),!u.defaultPrevented}return!0}}function ne(t,e){const n=t.$$.callbacks[e.type];n&&n.slice().forEach(i=>i.call(this,e))}const x=[],J=[],C=[],K=[],nt=Promise.resolve();let B=!1;function it(){B||(B=!0,nt.then(rt))}function ie(){return it(),nt}function D(t){C.push(t)}const R=new Set;let b=0;function rt(){if(b!==0)return;const t=k;do{try{for(;b<x.length;){const e=x[b];b++,N(e),Ct(e.$$)}}catch(e){throw x.length=0,b=0,e}for(N(null),x.length=0,b=0;J.length;)J.pop()();for(let e=0;e<C.length;e+=1){const n=C[e];R.has(n)||(R.add(n),n())}C.length=0}while(x.length);for(;K.length;)K.pop()();B=!1,R.clear(),N(t)}function Ct(t){if(t.fragment!==null){t.update(),v(t.before_update);const e=t.dirty;t.dirty=[-1],t.fragment&&t.fragment.p(t.ctx,e),t.after_update.forEach(D)}}let E;function St(){return E||(E=Promise.resolve(),E.then(()=>{E=null})),E}function z(t,e,n){t.dispatchEvent(et(`${e?"intro":"outro"}${n}`))}const S=new Set;let p;function re(){p={r:0,c:[],p}}function se(){p.r||v(p.c),p=p.p}function jt(t,e){t&&t.i&&(S.delete(t),t.i(e))}function ce(t,e,n,i){if(t&&t.o){if(S.has(t))return;S.add(t),p.c.push(()=>{S.delete(t),i&&(n&&t.d(1),i())}),t.o(e)}else i&&i()}const Mt={duration:0};function le(t,e,n,i){const r={direction:"both"};let u=e(t,n,r),s=i?0:1,c=null,l=null,o=null;function _(){o&&kt(t,o)}function a(f,d){const m=f.b-s;return d*=Math.abs(m),{a:s,b:f.b,d:m,duration:d,start:f.start,end:f.start+d,group:f.group}}function h(f){const{delay:d=0,duration:m=300,easing:y=ct,tick:g=w,css:O}=u||Mt,L={start:at()+d,b:f};f||(L.group=p,p.r+=1),c||l?l=L:(O&&(_(),o=G(t,s,f,m,d,y,O)),f&&g(0,1),c=a(L,m),D(()=>z(t,f,"start")),ft(A=>{if(l&&A>l.start&&(c=a(l,m),l=null,z(t,c.b,"start"),O&&(_(),o=G(t,s,c.b,c.duration,0,y,u.css))),c){if(A>=c.end)g(s=c.b,1-s),z(t,c.b,"end"),l||(c.b?_():--c.group.r||v(c.group.c)),c=null;else if(A>=c.start){const st=A-c.start;s=c.a+c.d*y(st/c.duration),g(s,1-s)}}return!!(c||l)}))}return{run(f){T(u)?St().then(()=>{u=u(r),h(f)}):h(f)},end(){_(),c=l=null}}}function oe(t){t&&t.c()}function ue(t,e){t&&t.l(e)}function Dt(t,e,n,i){const{fragment:r,after_update:u}=t.$$;r&&r.m(e,n),i||D(()=>{const s=t.$$.on_mount.map(Q).filter(T);t.$$.on_destroy?t.$$.on_destroy.push(...s):v(s),t.$$.on_mount=[]}),u.forEach(D)}function Pt(t,e){const n=t.$$;n.fragment!==null&&(v(n.on_destroy),n.fragment&&n.fragment.d(e),n.on_destroy=n.fragment=null,n.ctx=[])}function Ot(t,e){t.$$.dirty[0]===-1&&(x.push(t),it(),t.$$.dirty.fill(0)),t.$$.dirty[e/31|0]|=1<<e%31}function ae(t,e,n,i,r,u,s,c=[-1]){const l=k;N(t);const o=t.$$={fragment:null,ctx:[],props:u,update:w,not_equal:r,bound:I(),on_mount:[],on_destroy:[],on_disconnect:[],before_update:[],after_update:[],context:new Map(e.context||(l?l.$$.context:[])),callbacks:I(),dirty:c,skip_bound:!1,root:e.target||l.$$.root};s&&s(o.root);let _=!1;if(o.ctx=n?n(t,e.props||{},(a,h,...f)=>{const d=f.length?f[0]:h;return o.ctx&&r(o.ctx[a],o.ctx[a]=d)&&(!o.skip_bound&&o.bound[a]&&o.bound[a](d),_&&Ot(t,a)),h}):[],o.update(),_=!0,v(o.before_update),o.fragment=i?i(o.ctx):!1,e.target){if(e.hydrate){_t();const a=xt(e.target);o.fragment&&o.fragment.l(a),a.forEach(Y)}else o.fragment&&o.fragment.c();e.intro&&jt(t.$$.fragment),Dt(t,e.target,e.anchor,e.customElement),dt(),rt()}N(l)}class fe{$destroy(){Pt(this,1),this.$destroy=w}$on(e,n){if(!T(n))return w;const i=this.$$.callbacks[e]||(this.$$.callbacks[e]=[]);return i.push(n),()=>{const r=i.indexOf(n);r!==-1&&i.splice(r,1)}}$set(e){this.$$set&&!ot(e)&&(this.$$.skip_bound=!0,this.$$set(e),this.$$.skip_bound=!1)}}export{Pt as A,ie as B,w as C,zt as D,Tt as E,qt as F,Bt as G,bt as H,Rt as I,Xt as J,Gt as K,v as L,ne as M,ct as N,D as O,le as P,ee as Q,Jt as R,fe as S,Ht as a,Ft as b,Wt as c,se as d,It as e,jt as f,re as g,Y as h,ae as i,te as j,Z as k,Qt as l,xt as m,Kt as n,Zt as o,Vt as p,F as q,vt as r,Lt as s,ce as t,Ut as u,J as v,Yt as w,oe as x,ue as y,Dt as z};
