import{S as B,i as z,s as C,k as g,a as A,l as p,m as b,h as _,c as M,n as h,b as I,H as m,C as V,q as D,r as j,J as te,K as U,u as q,L as de,M as X,e as le,g as fe,t as $,d as ue,f as w,D as W,E as G,F as K,G as Q,N as _e,O as se,P as J,x as T,y as H,z as N,A as R,Q as me,R as he,o as ve,T as ge}from"../../chunks/index-5dba3f14.js";function pe(r){let e,t,l,s,n,f,c,a,o;return{c(){e=g("div"),t=g("div"),l=g("div"),s=A(),n=g("div"),f=A(),c=g("div"),a=A(),o=g("div"),this.h()},l(i){e=p(i,"DIV",{class:!0});var u=b(e);t=p(u,"DIV",{class:!0});var d=b(t);l=p(d,"DIV",{class:!0}),b(l).forEach(_),s=M(d),n=p(d,"DIV",{class:!0}),b(n).forEach(_),f=M(d),c=p(d,"DIV",{class:!0}),b(c).forEach(_),a=M(d),o=p(d,"DIV",{class:!0}),b(o).forEach(_),d.forEach(_),u.forEach(_),this.h()},h(){h(l,"class","svelte-609eia"),h(n,"class","svelte-609eia"),h(c,"class","svelte-609eia"),h(o,"class","svelte-609eia"),h(t,"class","lds-ring svelte-609eia"),h(e,"class","loading svelte-609eia")},m(i,u){I(i,e,u),m(e,t),m(t,l),m(t,s),m(t,n),m(t,f),m(t,c),m(t,a),m(t,o)},p:V,i:V,o:V,d(i){i&&_(e)}}}class be extends B{constructor(e){super(),z(this,e,null,pe,C,{})}}function ne(r){let e,t;return{c(){e=g("p"),t=D(r[5]),this.h()},l(l){e=p(l,"P",{class:!0});var s=b(e);t=j(s,r[5]),s.forEach(_),this.h()},h(){h(e,"class","error-message svelte-fnw9b9")},m(l,s){I(l,e,s),m(e,t)},p(l,s){s&32&&q(t,l[5])},d(l){l&&_(e)}}}function ye(r){let e,t,l,s,n,f,c,a,o=r[5]&&!r[4]&&r[6]&&ne(r);return{c(){e=g("div"),t=g("label"),l=D(r[1]),s=A(),n=g("input"),f=A(),o&&o.c(),this.h()},l(i){e=p(i,"DIV",{class:!0});var u=b(e);t=p(u,"LABEL",{for:!0,class:!0});var d=b(t);l=j(d,r[1]),d.forEach(_),s=M(u),n=p(u,"INPUT",{type:!0,id:!0,class:!0}),f=M(u),o&&o.l(u),u.forEach(_),this.h()},h(){h(t,"for",r[0]),h(t,"class","svelte-fnw9b9"),h(n,"type",r[3]),h(n,"id",r[0]),n.value=r[2],h(n,"class","svelte-fnw9b9"),te(n,"invalid",!r[4]&&r[6]),h(e,"class","form-control svelte-fnw9b9")},m(i,u){I(i,e,u),m(e,t),m(t,l),m(e,s),m(e,n),m(e,f),o&&o.m(e,null),c||(a=[U(n,"input",r[7]),U(n,"blur",r[8])],c=!0)},p(i,[u]){u&2&&q(l,i[1]),u&1&&h(t,"for",i[0]),u&8&&h(n,"type",i[3]),u&1&&h(n,"id",i[0]),u&4&&n.value!==i[2]&&(n.value=i[2]),u&80&&te(n,"invalid",!i[4]&&i[6]),i[5]&&!i[4]&&i[6]?o?o.p(i,u):(o=ne(i),o.c(),o.m(e,null)):o&&(o.d(1),o=null)},i:V,o:V,d(i){i&&_(e),o&&o.d(),c=!1,de(a)}}}function Ee(r,e,t){let{id:l}=e,{label:s}=e,{value:n}=e,{type:f="text"}=e,{valid:c=!0}=e,{validityMessage:a=""}=e,o=!1;function i(d){X.call(this,r,d)}const u=()=>t(6,o=!0);return r.$$set=d=>{"id"in d&&t(0,l=d.id),"label"in d&&t(1,s=d.label),"value"in d&&t(2,n=d.value),"type"in d&&t(3,f=d.type),"valid"in d&&t(4,c=d.valid),"validityMessage"in d&&t(5,a=d.validityMessage)},[l,s,n,f,c,a,o,i,u]}class re extends B{constructor(e){super(),z(this,e,Ee,ye,C,{id:0,label:1,value:2,type:3,valid:4,validityMessage:5})}}function ke(r){let e,t,l,s,n;const f=r[6].default,c=W(f,r,r[5],null);return{c(){e=g("button"),c&&c.c(),this.h()},l(a){e=p(a,"BUTTON",{class:!0,type:!0});var o=b(e);c&&c.l(o),o.forEach(_),this.h()},h(){h(e,"class",t=r[2]+" "+r[3]+" svelte-1tymv0c"),h(e,"type",r[0]),e.disabled=r[4]},m(a,o){I(a,e,o),c&&c.m(e,null),l=!0,s||(n=U(e,"click",r[7]),s=!0)},p(a,o){c&&c.p&&(!l||o&32)&&G(c,f,a,a[5],l?Q(f,a[5],o,null):K(a[5]),null),(!l||o&12&&t!==(t=a[2]+" "+a[3]+" svelte-1tymv0c"))&&h(e,"class",t),(!l||o&1)&&h(e,"type",a[0]),(!l||o&16)&&(e.disabled=a[4])},i(a){l||(w(c,a),l=!0)},o(a){$(c,a),l=!1},d(a){a&&_(e),c&&c.d(a),s=!1,n()}}}function $e(r){let e,t;const l=r[6].default,s=W(l,r,r[5],null);return{c(){e=g("a"),s&&s.c(),this.h()},l(n){e=p(n,"A",{href:!0,class:!0});var f=b(e);s&&s.l(f),f.forEach(_),this.h()},h(){h(e,"href",r[1]),h(e,"class","svelte-1tymv0c")},m(n,f){I(n,e,f),s&&s.m(e,null),t=!0},p(n,f){s&&s.p&&(!t||f&32)&&G(s,l,n,n[5],t?Q(l,n[5],f,null):K(n[5]),null),(!t||f&2)&&h(e,"href",n[1])},i(n){t||(w(s,n),t=!0)},o(n){$(s,n),t=!1},d(n){n&&_(e),s&&s.d(n)}}}function we(r){let e,t,l,s;const n=[$e,ke],f=[];function c(a,o){return a[1]?0:1}return e=c(r),t=f[e]=n[e](r),{c(){t.c(),l=le()},l(a){t.l(a),l=le()},m(a,o){f[e].m(a,o),I(a,l,o),s=!0},p(a,[o]){let i=e;e=c(a),e===i?f[e].p(a,o):(fe(),$(f[i],1,1,()=>{f[i]=null}),ue(),t=f[e],t?t.p(a,o):(t=f[e]=n[e](a),t.c()),w(t,1),t.m(l.parentNode,l))},i(a){s||(w(t),s=!0)},o(a){$(t),s=!1},d(a){f[e].d(a),a&&_(l)}}}function Ie(r,e,t){let{$$slots:l={},$$scope:s}=e,{type:n="button"}=e,{href:f=null}=e,{mode:c=null}=e,{color:a=null}=e,{disabled:o=!1}=e;function i(u){X.call(this,r,u)}return r.$$set=u=>{"type"in u&&t(0,n=u.type),"href"in u&&t(1,f=u.href),"mode"in u&&t(2,c=u.mode),"color"in u&&t(3,a=u.color),"disabled"in u&&t(4,o=u.disabled),"$$scope"in u&&t(5,s=u.$$scope)},[n,f,c,a,o,s,l,i]}class Se extends B{constructor(e){super(),z(this,e,Ie,we,C,{type:0,href:1,mode:2,color:3,disabled:4})}}function De(r){const e=r-1;return e*e*e+1}function ae(r,{delay:e=0,duration:t=400,easing:l=_e}={}){const s=+getComputedStyle(r).opacity;return{delay:e,duration:t,easing:l,css:n=>`opacity: ${n*s}`}}function oe(r,{delay:e=0,duration:t=400,easing:l=De,x:s=0,y:n=0,opacity:f=0}={}){const c=getComputedStyle(r),a=+c.opacity,o=c.transform==="none"?"":c.transform,i=a*(1-f);return{delay:e,duration:t,easing:l,css:(u,d)=>`
			transform: ${o} translate(${(1-u)*s}px, ${(1-u)*n}px);
			opacity: ${a-i*d}`}}const je=r=>({}),ie=r=>({});function Ae(r){let e,t,l,s,n,f,c,a,o,i,u,d;const S=r[2].default,E=W(S,r,r[1],null),P=r[2].footer,k=W(P,r,r[1],ie);return{c(){e=g("div"),l=A(),s=g("div"),n=g("h1"),f=D(r[0]),c=A(),a=g("div"),E&&E.c(),o=A(),i=g("footer"),k&&k.c(),this.h()},l(v){e=p(v,"DIV",{class:!0}),b(e).forEach(_),l=M(v),s=p(v,"DIV",{class:!0});var y=b(s);n=p(y,"H1",{class:!0});var L=b(n);f=j(L,r[0]),L.forEach(_),c=M(y),a=p(y,"DIV",{class:!0});var O=b(a);E&&E.l(O),O.forEach(_),o=M(y),i=p(y,"FOOTER",{class:!0});var F=b(i);k&&k.l(F),F.forEach(_),y.forEach(_),this.h()},h(){h(e,"class","modal-backdrop svelte-jozdve"),h(n,"class","svelte-jozdve"),h(a,"class","content svelte-jozdve"),h(i,"class","svelte-jozdve"),h(s,"class","modal svelte-jozdve")},m(v,y){I(v,e,y),I(v,l,y),I(v,s,y),m(s,n),m(n,f),m(s,c),m(s,a),E&&E.m(a,null),m(s,o),m(s,i),k&&k.m(i,null),d=!0},p(v,[y]){(!d||y&1)&&q(f,v[0]),E&&E.p&&(!d||y&2)&&G(E,S,v,v[1],d?Q(S,v[1],y,null):K(v[1]),null),k&&k.p&&(!d||y&2)&&G(k,P,v,v[1],d?Q(P,v[1],y,je):K(v[1]),ie)},i(v){d||(se(()=>{t||(t=J(e,ae,{},!0)),t.run(1)}),w(E,v),w(k,v),se(()=>{u||(u=J(s,oe,{y:300},!0)),u.run(1)}),d=!0)},o(v){t||(t=J(e,ae,{},!1)),t.run(0),$(E,v),$(k,v),u||(u=J(s,oe,{y:300},!1)),u.run(0),d=!1},d(v){v&&_(e),v&&t&&t.end(),v&&_(l),v&&_(s),E&&E.d(v),k&&k.d(v),v&&u&&u.end()}}}function Me(r,e,t){let{$$slots:l={},$$scope:s}=e,{title:n}=e;return r.$$set=f=>{"title"in f&&t(0,n=f.title),"$$scope"in f&&t(1,s=f.$$scope)},[n,s,l]}class ce extends B{constructor(e){super(),z(this,e,Me,Ae,C,{title:0})}}function Ve(r){let e,t,l,s,n,f,c;return t=new re({props:{id:"username",label:"Username",valid:r[1],validityMessage:"Please enter a valid username.",value:r[2]}}),t.$on("input",r[6]),s=new re({props:{id:"password",label:"Password",type:"password",valid:r[0],validityMessage:"Please enter a valid password.",value:r[3]}}),s.$on("input",r[7]),{c(){e=g("form"),T(t.$$.fragment),l=A(),T(s.$$.fragment),this.h()},l(a){e=p(a,"FORM",{class:!0});var o=b(e);H(t.$$.fragment,o),l=M(o),H(s.$$.fragment,o),o.forEach(_),this.h()},h(){h(e,"class","svelte-nm5p4o")},m(a,o){I(a,e,o),N(t,e,null),m(e,l),N(s,e,null),n=!0,f||(c=U(e,"submit",he(r[5])),f=!0)},p(a,o){const i={};o&2&&(i.valid=a[1]),o&4&&(i.value=a[2]),t.$set(i);const u={};o&1&&(u.valid=a[0]),o&8&&(u.value=a[3]),s.$set(u)},i(a){n||(w(t.$$.fragment,a),w(s.$$.fragment,a),n=!0)},o(a){$(t.$$.fragment,a),$(s.$$.fragment,a),n=!1},d(a){a&&_(e),R(t),R(s),f=!1,c()}}}function Le(r){let e;return{c(){e=D("Log in")},l(t){e=j(t,"Log in")},m(t,l){I(t,e,l)},d(t){t&&_(e)}}}function Pe(r){let e,t,l;return t=new Se({props:{type:"button",disabled:!r[4],$$slots:{default:[Le]},$$scope:{ctx:r}}}),t.$on("click",r[5]),{c(){e=g("div"),T(t.$$.fragment),this.h()},l(s){e=p(s,"DIV",{slot:!0});var n=b(e);H(t.$$.fragment,n),n.forEach(_),this.h()},h(){h(e,"slot","footer")},m(s,n){I(s,e,n),N(t,e,null),l=!0},p(s,n){const f={};n&16&&(f.disabled=!s[4]),n&512&&(f.$$scope={dirty:n,ctx:s}),t.$set(f)},i(s){l||(w(t.$$.fragment,s),l=!0)},o(s){$(t.$$.fragment,s),l=!1},d(s){s&&_(e),R(t)}}}function Te(r){let e,t;return e=new ce({props:{title:"Please log in!",$$slots:{footer:[Pe],default:[Ve]},$$scope:{ctx:r}}}),{c(){T(e.$$.fragment)},l(l){H(e.$$.fragment,l)},m(l,s){N(e,l,s),t=!0},p(l,[s]){const n={};s&543&&(n.$$scope={dirty:s,ctx:l}),e.$set(n)},i(l){t||(w(e.$$.fragment,l),t=!0)},o(l){$(e.$$.fragment,l),t=!1},d(l){R(e,l)}}}function He(r,e,t){let l,s,n,f="",c="";const a=me();function o(){a("loginStarted"),fetch("http://localhost:8091/api/login",{method:"POST",body:JSON.stringify({username:f,password:c}),headers:{"Content-Type":"application/json"}}).then(S=>{if(S.ok)return S.text();throw new Error("An error occurred, please try again!")}).then(S=>{const E=JSON.parse(S);localStorage.setItem("jwt",E.access_token),localStorage.setItem("userName",E.username),localStorage.setItem("userRoles",E.roles),a("loginFinished")}).catch(S=>{console.log(S)})}const i=d=>t(2,f=d.target.value),u=d=>t(3,c=d.target.value);return r.$$.update=()=>{r.$$.dirty&3&&t(4,n=l&&s)},t(1,l=!0),t(0,s=!0),[s,l,f,c,n,o,i,u]}class Ne extends B{constructor(e){super(),z(this,e,He,Te,C,{})}}function Re(r){let e,t,l;return{c(){e=g("header"),t=g("h1"),l=D("Apartment Manager"),this.h()},l(s){e=p(s,"HEADER",{class:!0});var n=b(e);t=p(n,"H1",{class:!0});var f=b(t);l=j(f,"Apartment Manager"),f.forEach(_),n.forEach(_),this.h()},h(){h(t,"class","svelte-1c6tx77"),h(e,"class","svelte-1c6tx77")},m(s,n){I(s,e,n),m(e,t),m(t,l)},p:V,i:V,o:V,d(s){s&&_(e)}}}class Oe extends B{constructor(e){super(),z(this,e,null,Re,C,{})}}function Be(r){let e,t=(r[0].length==0?"We do not know any details, sorry":r[0])+"",l;return{c(){e=g("p"),l=D(t)},l(s){e=p(s,"P",{});var n=b(e);l=j(n,t),n.forEach(_)},m(s,n){I(s,e,n),m(e,l)},p(s,n){n&1&&t!==(t=(s[0].length==0?"We do not know any details, sorry":s[0])+"")&&q(l,t)},d(s){s&&_(e)}}}function ze(r){let e,t;return e=new ce({props:{title:"An error occurred!",$$slots:{default:[Be]},$$scope:{ctx:r}}}),e.$on("cancel",r[1]),{c(){T(e.$$.fragment)},l(l){H(e.$$.fragment,l)},m(l,s){N(e,l,s),t=!0},p(l,[s]){const n={};s&5&&(n.$$scope={dirty:s,ctx:l}),e.$set(n)},i(l){t||(w(e.$$.fragment,l),t=!0)},o(l){$(e.$$.fragment,l),t=!1},d(l){R(e,l)}}}function Ce(r,e,t){let{message:l}=e;function s(n){X.call(this,r,n)}return r.$$set=n=>{"message"in n&&t(0,l=n.message)},[l,s]}let Fe=class extends B{constructor(e){super(),z(this,e,Ce,ze,C,{message:0})}};function qe(r){let e,t,l,s,n,f,c,a,o,i,u,d,S,E,P,k,v;return{c(){e=g("article"),t=g("header"),l=g("h1"),s=D("Hello "),n=D(r[0]),f=D("! you have the following roles: "),c=D(r[1]),a=A(),o=g("h2"),i=D("subtttitle"),u=A(),d=g("p"),S=D("adddress"),E=A(),P=g("div"),k=g("p"),v=D('"testing..."'),this.h()},l(y){e=p(y,"ARTICLE",{class:!0});var L=b(e);t=p(L,"HEADER",{class:!0});var O=b(t);l=p(O,"H1",{class:!0});var F=b(l);s=j(F,"Hello "),n=j(F,r[0]),f=j(F,"! you have the following roles: "),c=j(F,r[1]),F.forEach(_),a=M(O),o=p(O,"H2",{class:!0});var Y=b(o);i=j(Y,"subtttitle"),Y.forEach(_),u=M(O),d=p(O,"P",{class:!0});var Z=b(d);S=j(Z,"adddress"),Z.forEach(_),O.forEach(_),E=M(L),P=p(L,"DIV",{class:!0});var x=b(P);k=p(x,"P",{class:!0});var ee=b(k);v=j(ee,'"testing..."'),ee.forEach(_),x.forEach(_),L.forEach(_),this.h()},h(){h(l,"class","svelte-19u3xfj"),h(o,"class","svelte-19u3xfj"),h(d,"class","svelte-19u3xfj"),h(t,"class","svelte-19u3xfj"),h(k,"class","svelte-19u3xfj"),h(P,"class","content svelte-19u3xfj"),h(e,"class","svelte-19u3xfj")},m(y,L){I(y,e,L),m(e,t),m(t,l),m(l,s),m(l,n),m(l,f),m(l,c),m(t,a),m(t,o),m(o,i),m(t,u),m(t,d),m(d,S),m(e,E),m(e,P),m(P,k),m(k,v)},p(y,[L]){L&1&&q(n,y[0]),L&2&&q(c,y[1])},i:V,o:V,d(y){y&&_(e)}}}function Je(r,e,t){let{user:l}=e,{roles:s}=e;return r.$$set=n=>{"user"in n&&t(0,l=n.user),"roles"in n&&t(1,s=n.roles)},[l,s]}class Ue extends B{constructor(e){super(),z(this,e,Je,qe,C,{user:0,roles:1})}}function We(r){let e,t;return e=new Fe({props:{message:Ye}}),{c(){T(e.$$.fragment)},l(l){H(e.$$.fragment,l)},m(l,s){N(e,l,s),t=!0},p:V,i(l){t||(w(e.$$.fragment,l),t=!0)},o(l){$(e.$$.fragment,l),t=!1},d(l){R(e,l)}}}function Ge(r){let e,t;return e=new Ne({}),e.$on("loginFinished",r[5]),e.$on("loginStarted",r[6]),{c(){T(e.$$.fragment)},l(l){H(e.$$.fragment,l)},m(l,s){N(e,l,s),t=!0},p:V,i(l){t||(w(e.$$.fragment,l),t=!0)},o(l){$(e.$$.fragment,l),t=!1},d(l){R(e,l)}}}function Ke(r){let e,t;return e=new Ue({props:{user:r[1],roles:r[2]}}),{c(){T(e.$$.fragment)},l(l){H(e.$$.fragment,l)},m(l,s){N(e,l,s),t=!0},p(l,s){const n={};s&2&&(n.user=l[1]),s&4&&(n.roles=l[2]),e.$set(n)},i(l){t||(w(e.$$.fragment,l),t=!0)},o(l){$(e.$$.fragment,l),t=!1},d(l){R(e,l)}}}function Qe(r){let e,t;return e=new be({}),{c(){T(e.$$.fragment)},l(l){H(e.$$.fragment,l)},m(l,s){N(e,l,s),t=!0},p:V,i(l){t||(w(e.$$.fragment,l),t=!0)},o(l){$(e.$$.fragment,l),t=!1},d(l){R(e,l)}}}function Xe(r){let e,t,l,s,n,f;t=new Oe({});const c=[Qe,Ke,Ge,We],a=[];function o(i,u){return i[3]&&!i[4]?0:i[0]&&!i[4]?1:!i[0]&&!i[4]?2:i[4]?3:-1}return~(s=o(r))&&(n=a[s]=c[s](r)),{c(){e=g("main"),T(t.$$.fragment),l=A(),n&&n.c()},l(i){e=p(i,"MAIN",{});var u=b(e);H(t.$$.fragment,u),l=M(u),n&&n.l(u),u.forEach(_)},m(i,u){I(i,e,u),N(t,e,null),m(e,l),~s&&a[s].m(e,null),f=!0},p(i,[u]){let d=s;s=o(i),s===d?~s&&a[s].p(i,u):(n&&(fe(),$(a[d],1,1,()=>{a[d]=null}),ue()),~s?(n=a[s],n?n.p(i,u):(n=a[s]=c[s](i),n.c()),w(n,1),n.m(e,null)):n=null)},i(i){f||(w(t.$$.fragment,i),w(n),f=!0)},o(i){$(t.$$.fragment,i),$(n),f=!1},d(i){i&&_(e),R(t),~s&&a[s].d()}}}let Ye="";function Ze(r,e,t){let l=!1,s="Anonymous",n=[],f=!0,c=!1;function a(){let i=localStorage.getItem("jwt");i!=null?fetch("http://localhost:8091/api/auth/valid",{headers:{"Content-Type":"application/json",Authorization:"Bearer "+i}}).then(u=>{u.status==204&&(t(3,f=!1),t(0,l=!0),t(1,s=localStorage.getItem("userName")),t(2,n=localStorage.getItem("userRoles")))}).catch(u=>{console.log(u),t(4,c=!0),t(3,f=!1)}):t(3,f=!1)}function o(){t(3,f=!0)}return ve(a),ge(()=>{console.log("Before update")}),[l,s,n,f,c,a,o]}class tt extends B{constructor(e){super(),z(this,e,Ze,Xe,C,{})}}export{tt as default};
